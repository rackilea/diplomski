public class test {

public static void main(String[] args) {
        Account [] accounts = new Account[10];
        mainMenuOptions(accounts);      
}
        //main menu option method
public static void mainMenuOptions(Account accounts){
    Scanner input = new Scanner(System.in);
    //enter id
    System.out.println("Enter an id: "); 
    int id = input.nextInt();

    //initialize 100 dollars
    for (int i = 0; i < accounts.length; i++) { 
        accounts[i] = new Account(i, 100); 
    }
    int index = -1; 
    for(int i = 0; i < accounts.length; i++) {
        if(accounts[i].getid() == id) {
        index = i; 
        i = accounts.length;
        }               
    }