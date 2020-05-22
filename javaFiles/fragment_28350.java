public class assign61 {

    public assign61(){
        iquote("Test");
        iquote("123");
        iquote("5.678");
        }

    public void iquote(String s){
        System.out.println("sQuote:" + s);
    }
    public void iquote(int n){
        System.out.println("iQuote:" + n);
    }       
    public void iquote(double d){
        System.out.println("dQuote:" + d);       
    }

    public static void main(String[] args){
        new assign61();
    }

}