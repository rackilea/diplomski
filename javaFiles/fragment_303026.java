public class InputBox extends Textbox {

    private Consumer<String> out;

    public InputBox(String message, Consumer<String> out) {
        this.out = out;
        ...
    }

    public void tick(Game game){
        ...
        out.apply(input);
        ...
    }
}