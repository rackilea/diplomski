public enum Email {
    WELCOME {
        protected void sendInternal(Message message) {
            WelcomeMessage wm = (WelcomeMessage) message;
            ....    
        }

        protected Class<? extends Message> getSupportedClass() {
            return WelcomeMessage.class;
        }
    },
    LOGIN {
        protected void sendInternal(Message message) {
            LoginMessage lm = (LoginMessage) message;
            .... 
        }

        protected Class<? extends Message> getSupportedClass() {
            return LoginMessage;
        }
    };

    public static void send(Message message) {
        for (Email email : values()) {
            if (email.getSupportedClass().equals(message.getClass()) {
                email.sendInternal(message);
            }
        }
    }
    protected abstract void sendInternal(Message message);
    protected abstract Class<? extends Message> getSupportedClass();
}