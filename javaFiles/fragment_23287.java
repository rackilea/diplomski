// The window has to be final to be accessible from our listener.
final Window window = new Window("Title", skin);

// Create our button.
TextButton button = new TextButton("Press me to close window!", skin);

// Here we add a click listener to our button.
button.addListener (new ChangeListener() {
    // This method is called whenever the actor is clicked. We override its behavior here.
    @Override
    public void changed(ChangeEvent event, Actor actor) {
        // This is where we remove the window.
        window.remove();
    }
});

// Add the button to our window.
window.add(button);

// Add the window to our stage.
stage.addActor(window);