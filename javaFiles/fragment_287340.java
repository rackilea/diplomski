import java.util.Scanner;

public class BookTest {

    public static void main(String[] args) {    

        Scanner scan = new Scanner (System.in);

        Book title = new Book();
        Book price = new Book();
        Book isbn = new Book();
        Book fName = new Book();
        Book sName = new Book();
        Book nation = new Book();

        System.out.print("Enter book title: ");
        title.setTitleBook(scan.nextLine());

        System.out.print("Enter book price: ");
        price.setPriceBook(scan.nextDouble());

        System.out.print("Enter book ISBN: ");
        isbn.setIsbn(scan.nextInt());

        scan.nextLine(); //NOTICE CHANGE HERE
        //System.out.println(); THIS WAS REMOVED


        System.out.print("Enter author Name: ");
        fName.setFirstName(scan.nextLine());

        System.out.print("Enter author Surname: ");
        sName.setSecondName(scan.nextLine());

        System.out.print("Enter author Nationality: ");
        nation.setNationality(scan.nextLine());


    System.out.println("Title: " +title.getTitleBook());
    System.out.println("Price: "+price.getPriceBook());
    System.out.println("ISNB Number: "+isbn.getIsbn());

    System.out.println("Author: "+ fName.getFirstName() + sName.getSecondName());
    System.out.println("Aurhor Nationality: " + nation.getNationality());



    }
}