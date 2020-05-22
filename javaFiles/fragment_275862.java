public enum MySingleton {
    INSTANCE

    public String getSarcasticMessage() {
        return "I'm a lazy loaded singleton, use me for everything!";
    }
}

MySingleton.INSTANCE.getSarcasticMessage();  // This is how to use it