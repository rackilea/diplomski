public class OptionScreen{
    private Rectangle sprite; // Make instance variable

    public OptionScreen(){ // Constructor - called when initializing
        sprite = new Rectangle(); // Initialize (so it's not null)
        ... // Set other info on sprite, such as x
    }

    public void render(float delta){
        ...
        sprite.x;
        ...
    }

    public static void main(String[] args){ // Example of useage
        OptionScreen optionScreen = new OptionScreen(); // Constructor called
        optionScreen.render(1.1);
    }
}