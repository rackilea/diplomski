public enum Email {
    WELCOME {
        public void send(Message message) {
            WelcomeMessage wm = (WelcomeMessage) message;
            ....    
        }
    },
    LOGIN {
        public void send(Message message) {
            LoginMessage lm = (LoginMessage) message;
            .... 
        }
    }
}