class Super
{
    public static void main (String[] args) {
        new Sub();
    }

    Super() {
        System.out.println("Super constructor");
        this.printThree();
    }

    protected void printThree() {
        System.out.println("Super's printThree");
    }
}
class Sub extends Super
{
    int three = this.initThree();

    Sub() {
        this.printThree();
    }

    private int initThree() {
        System.out.println("Sub's initThree");
        return 3;
    }

    protected void printThree() {
        System.out.println("Sub's printThree: " + this.three);
    }
}