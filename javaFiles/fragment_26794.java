public class SumeMain {

public static void main(String[] args) {

    Book b = new Book(1);
    Book b1 = new Book(2);
    Book b2 = new Book();

    System.out.println(b);
    System.out.println(b1);

    //Note below book not yet has a number:
    System.out.println("Forgotten book: "+b2);

    //But you can set it from "outside" (here)
    b2.setBookNumber(3);

    System.out.println(b2);

    //Also note you now took controll of those numbers so two books can have the same number:
    b2.setBookNumber(2);

    System.out.println("Duplicate book number: "+b2);
}


}