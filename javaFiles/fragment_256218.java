public class Person {
    private int height;

    public Person(int height) {
        this.setHeight(height);
    }

    @SuppressWarnings("unused")
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}