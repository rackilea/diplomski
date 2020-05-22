/*
* This method is responsible for intercepting all the queues/topics that are created in the system.
* In this particular case we are interested only in the queues, in order we can mirror *some* of them and get
* a copy of the messages that are sent to them (With the topics this mirroring is not necessary since we would just
* subscribe to that topic for receiving the same message).
* */
public Destination intercept(final Destination destination) {
    if (destination.getActiveMQDestination().isQueue()) {
        if (isPrefixMirrored(destination) && (!destination.getActiveMQDestination().isTemporary() || brokerService.isUseTempMirroredQueues())) {
            try {
                //we create a mirrored queue for that destination
                final Destination mirrorDestination = getMirrorDestination(destination);
                if (mirrorDestination != null) {
                    return new DestinationFilter(destination) {
                        public void send(ProducerBrokerExchange context, Message message) throws Exception {
                            message.setDestination(mirrorDestination.getActiveMQDestination());
                            mirrorDestination.send(context, message);

                            if (isCopyMessage()) {
                                message = message.copy();
                            }
                            message.setDestination(destination.getActiveMQDestination());
                            message.setMemoryUsage(null); // set this to null so that it will use the queue memoryUsage instance instead of the topic.
                            super.send(context, message);
                        }
                    };
                }
            } catch (Exception e) {
                LOG.error("Failed to lookup the mirror destination for: {}", destination, e);
            }
        }
    }
    return destination;
}

/*
* @returns true if the destination passed as parameter will be mirrored. If the value for the attribute "mirroring"
* is an empty string "" then all the queues will be mirrored by default.
**/
private boolean isPrefixMirrored(Destination destination) {
    if (mirroring.equals("")) {
        return true;
    }
    List<String> mirroredQueuesPrefixes = Arrays.asList(mirroring.split(","));
    final String destinationPhysicalName = destination.getActiveMQDestination().getPhysicalName();
    return mirroredQueuesPrefixes.stream().map(String::trim).anyMatch(destinationPhysicalName::contains);
}