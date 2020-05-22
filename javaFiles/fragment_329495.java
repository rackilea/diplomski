event.getNodeInstance().getNode().getMetaData().get("Lane");

@Override
public void beforeNodeTriggered(ProcessNodeTriggeredEvent event) {
        log.info("before node triggered " + event.getNodeInstance().getNodeName());
        log.info("   in lane " + event.getNodeInstance().getNode().getMetaData().get("Lane"));
}