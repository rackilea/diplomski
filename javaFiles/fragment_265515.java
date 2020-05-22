public class BankMain {
private ArrayList<Integer> cardNum = new ArrayList<Integer>();
// rest of code as it is 
..
..
 BankMain main = new BankMain();
 //change
    main.menu();

 //no need foe static
  public void cardNumbers(){
//no need here now        
//ArrayList<Integer> cardNum = new ArrayList<Integer>();
        Scanner cards = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
..
..

//public static void menu(){
  public void menu(){


//send the list
 //I see there are confusion at times regarding calling of static method.
 //please note objectname.staticMethod() or classname.staticMethod() is one 
 //and same thing. Just that classname.staticMethod() is more clear 
 BankMainPart2.loginCard(cardNum);

}