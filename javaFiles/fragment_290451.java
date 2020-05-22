public class Main {

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    Reservations.setupMap(); //Run to test TODO: remove setupMap() from Reservation class 
    Reservations.addGuest(Reservations.DAY_MON, Reservations.ROOM_2, 1230, "John Doe");

    TreeSet<String> set = new TreeSet<String>();
    for(String s: Reservations.getOrderedOutputStrings()){
        System.out.println(s + "\n");
    }


}
}