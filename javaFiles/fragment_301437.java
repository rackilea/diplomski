public enum Controls implements Behaviour {
    JUMP("Player jumped..."),
    MOVE_LEFT("Player moved left..."),
    MOVE_RIGHT("Player moved right...");

    private final String message;

    Controls(String message) {
        this.message = message;
    }

    @Override    
    public void invoke() {
        System.out.println(message);
    }
}