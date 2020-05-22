import java.util.Date;

public class Test {
         public static void main(String... abc){
             Customer[] a = new STCustomer[20];
             a[0] = new STCustomer();
             a[1] = new STCustomer("Hello","World",12L,new Date());
             a[1] = new STCustomer("Hello","World",12L);
         }
}

class Customer{
    public Customer(){
        System.out.println("Customer()");
    }

    public Customer(String a, String b, long c,Date d){
        System.out.println("Customer(String a, String b, long c,Date d)");
            // Set values to fields
    }
}

class STCustomer extends Customer{
    public STCustomer(){}

    public STCustomer(String a, String b, long c,Date d){

    }

    public STCustomer(String a, String b, long c){
      super(a,b,c,new Date());
    }
}