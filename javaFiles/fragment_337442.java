public class C { 

    int i;
    String[] s;

    public C(int i, String... s){
        this.i = i;
        this.s=s;
    }
}
new C(4,"a","b") // will be transformed to int and String[]