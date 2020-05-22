interface A
{
    void foo();
    default void toOverride() {
        System.out.println("A");
    }
}
interface B extends A
{
    default void toOverride() {
        A.super.toOverride();
        System.out.println("B");
    }
}
interface C extends B
{
    default void toOverride() {
        A.super.toOverride();// does not work
        B.super.toOverride();
        System.out.println("B");
    }
}
class D implements B
{
    public void toOverride() {

    }    
    public void foo() {
        D.this.toOverride();
        B.super.toOverride();
        A.super.toOverride(); // does not work!
    }
}