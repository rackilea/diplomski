public class MyMath extends Homework {

    private int pagesRead;
    private String typeHomework;

    public MyMath(int pages, String hw) {
        super(pages,hw);
    }

    public void createAssignment(int p) {
        setTypeHomework("Math");
        setPagesToRead(p);
    }

    public String toString() {
        return typeHomework + " - " + pagesRead;
    }
}