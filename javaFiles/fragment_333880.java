import java.util.Scanner;

public class AssignmentArrays{

static int[] data = new int [6];

public static void getSegmentIDs() {
   ...
}

pubilc static int getUserMenuChoice() {
   ...
}

public static void main(String[] args){

 int exit = false;

 while(!exit) {
   getSegmentIDs();
   choice = getUserMenuChoice();
   if (choice == 0) exit = true;
 } 

}
}