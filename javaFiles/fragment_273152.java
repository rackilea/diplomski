// enum that encapsulates the 3 possible states of the traffic light
enum LightState {
    RED("Red", Color.RED), YELLOW("Yellow", Color.YELLOW), GREEN("Green", Color.GREEN);

    private LightState(String text, Color color) {
        this.text = text;
        this.color = color;
    }

    private String text;
    private Color color;

    public String getText() {
        return text;
    }
    public Color getColor() {
        return color;
    }    
}