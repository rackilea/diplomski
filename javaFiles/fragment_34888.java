public class Button {
    private Callback callback;

    public Button(Callback callback) {
        this.callback = callback;
    }

    public void update() {
        // Check if clicked..
        callback.onClick(this);
    }

    public interface Callback {
        public void onClick(Button Button);
    }
}


Button b = new Button(new Callback() {
    @Override
    public void onClick(Button b) {
        System.out.println("Clicked");
    }
});