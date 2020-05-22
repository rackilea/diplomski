public abstract class Homework {
    private int pagesToRead;
    private String typeHomework;

    {
        // initialise instance variables
        pagesToRead = 0;
        typeHomework = "none";
    }

    public Homework(int pages, String hw) {

        this.pagesToRead = pages;
        this.typeHomework = hw;

    }

    public abstract void createAssignment(int p);

    public int getPages() {
        return pagesToRead;
    }

    public void setPagesToRead(int p) {
        pagesToRead = p;
    }

    public String getTypeHomework() {
        return typeHomework;
    }

    public void setTypeHomework(String hw) {
        typeHomework = hw;
    }

}