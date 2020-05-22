public class BiteHandler implements EventHandler<ActionEvent> {
    private String message_;

    /**
     * Think of a constructor as any other method, however, it is special
     * in that it is named after the class. Because it is named
     * after the class, the compiler knows that the first thing
     * that needs to be done when instantiating this class. A 
     * constructor is "automatic work" that "constructs" your object. 
     * In this class, when you instantiate it, a message is required.
     * this message is stored in a "private class member" to be accessed
     * later on when the bite() method is called
     */
    public BiteHandler(String message) {
        message_ = message;
    }

    @Override
    public void handle(ActionEvent event) {
        bite();
    }

    public void bite() {
        System.out.println(message_);
    }
}