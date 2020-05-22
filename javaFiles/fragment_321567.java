public class ViewController {

    ...

    public ViewController() {
         doOpenAsXML();  // open historical data, put into 'hist'
         InputScreen home = new InputScreen (this); // give myself to our new InputScreen.
         // do something with home
    }

    public void doSaveAsXML() {
    // ...long block to save in correct xml format
    }

    public void doOpenAsXML() {
    // ...long block to open in correct xml format
    }


}

public class InputScreen {

    private ViewController controller;

    public InputScreen(ViewController contr) {
       this.controller = contr;
    }


    void someMethod() {
        // statements to define a screen with text fields and a 'Save' button
        // statements to create a listener on the Save button
        // statements to add to the ArrayList hist, opened in the ViewController method
        controller.doSaveAsXML();
    }
}