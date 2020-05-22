public class Book {
    private string title;
    private HashMap<String, Person> personMap = new HashMap<String, Person>();
    private boolean checkedOut;

    public Book(String title) {
        this.title = title;
    }

    public boolean getCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}