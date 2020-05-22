public class B extends A {

    private A decorated;
    public B(A decorated) {
        this.decorated = decorated;
    }

    @Override
    public String getID() {
        return "id of B";
    }

    @Override
    public void otherMethodOfA() {
        return decorated.otherMethodOfA();
    }
}