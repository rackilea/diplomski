public class SomeObject {
    private EventListener lst;

    public void setListener (EventListener lst) {
        this.lst = lst;
    }

    public void somethingHappened () {
        lst.fireEvent(new Event("Something Happened"));
    }
}