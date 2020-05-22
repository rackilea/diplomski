public class myFile {
    private myView view;

    public myFile (myView view) {
        this.view = view;
    }

    public void somethingHappened () {
        view.someMethod ();
    }
}