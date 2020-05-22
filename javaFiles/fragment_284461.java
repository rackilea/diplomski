@GET
@Produces(SseFeature.SERVER_SENT_EVENTS)
@Path("/checkExamNotification")
public EventOutput checkExamNotification(@QueryParam("accountId") final int accountId, @QueryParam("sessionId") final String sessionId) {
    final EventOutput eventOutput = new EventOutput();
    if (memCachedClient.checkSession(sessionId, accountId)) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    if (examNotificationQueue.hasItems()) {
                        ExamNotificationQueueItemModel examNotificationQueueItemModel = examNotificationQueue.dequeue();
                        if (examNotificationQueueItemModel.getAccountId() == accountId) {
                            LOGGER.info("[START] Check exam notification API");
                            LOGGER.info("Account ID: " + accountId);
                            LOGGER.info("Get notification with exam ID: " + examNotificationQueueItemModel.getExamName());
                            String result = gson.toJson(examNotificationQueueItemModel);
                            final OutboundEvent.Builder eventBuilder
                                    = new OutboundEvent.Builder();
                            eventBuilder.data(result);
                            final OutboundEvent event = eventBuilder.build();
                            eventOutput.write(event);
                            LOGGER.info("[END]");
                        } else {
                            examNotificationQueue.enqueue(examNotificationQueueItemModel);
                        }
                    }

                } catch (IOException e) {
                    throw new RuntimeException(
                            "Error when writing the event.", e);
                } finally {
                    try {
                        eventOutput.close();
                    } catch (IOException ioClose) {
                        throw new RuntimeException(
                                "Error when closing the event output.", ioClose);
                    }
                }
            }
        }).start();
    }

    return eventOutput;
}