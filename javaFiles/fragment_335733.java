public interface MyInterface{
    AtomicReference<String> NAME = new AtomicReference<String>("Fred");
}


public static void main(final String[] args){
    System.out.println(MyInterface.NAME);
    MyInterface.NAME.set("Jim");
    System.out.println(MyInterface.NAME);
}