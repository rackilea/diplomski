public class MyClass {
    private int minutes;

    public MyClass clone() {
        MyClass clonedInstance = new MyClass();
        clonedInstance.setMinutes(getMinutes());
        return clonedInstance;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}