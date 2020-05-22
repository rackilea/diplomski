public class MyObject {

    private Context context;
    private MyInterface inter;

    public MyObject(Context context, MyInterface inter) {
        this.context = context;
        this.inter =  inter;
        inter.aMethod();
    }
}