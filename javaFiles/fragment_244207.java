enum EventType {
    MESSAGE {
        @Override
        public void handleMessage(Service service, Message message) {
            service.onMessage(message);
        }
    },
    STAR_ADDED {
        @Override
        public void handleMessage(Service service, Message message) {
            service.onStarAdded(message);
        }

        public abstract void handleMessage(Service service, Message message);
    }
}