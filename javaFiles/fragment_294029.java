public class MainClass{
   public static void main(String[] args) {
       Menu menu = new Menu();
       /* create your scanner here, and call the methods on the Menu depending on the user's choice */

       // a switch for the user's selection might be a good idea:
       switch(selected){
           case 1:
                menu.purchaseItems();
                break;
           case 2:
                // you get the point. I leave this to you.
           default:
                sysout("Invalid selection");
                break;
       }

   }
}