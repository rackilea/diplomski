abstract class Demo1{
    int x=10;
    abstract String s();

    void show(){
       System.out.println(this.x);
       System.out.println(this.s());
    }
}
class Demo2 extends Demo1 {
    String s = "foo";
    public String s() { return s; }
}