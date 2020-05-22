public class Main {

public static void main(String[] args) {


   System.out.println("Would you like to add a new CD");
 CDList list=new CDList(2);  // Two is the No of CDs you can prompt the user to enter by reading the input and pass it to the constructor
    for (int i=0; i < 2 ; i++) {
        list.add();
    }   
    list.SortArtist();
    list.Display();

}