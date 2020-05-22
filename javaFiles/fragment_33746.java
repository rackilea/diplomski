public class Seating {

 private static int FIRSTCLASS= 12;    // Make these constants static since they pertain to all 
 private static int ECONOMYCLASS= 240; // instances of your class. That way there is exactly on
                                       // copy of the variables, which is more memory efficient.
 private int occupied;
 private column;  // Okay but Java convention is to declare each member variable on its own line
                  // increases code readability.
 private String[][] seatchart;
 private int[][] seatlist;
 private String[][] namelist;
 private String locSeatClass;
 private String name;

 public String customer; // Okay but better to leave this private and then provide getter and
                         // setter methods to provide access to this string. Much easier to track
                         // down who is changing its value in your code.

public Seating(String seatclass) { // Java convention is to place the opening bracket here not
                                   // on the next line.  
    // Make sure that seatClass is not null or empty. NOTE: This is a neat trick for
    // simultaneously checking for both null and empty strings in one shot. Otherwise, you have
    // you have to check for null and then examine the string's length which is more code.
    if ("".equalsIgnoreCase(seatClass) {
        throw new IllegalArgumentException("Seat class undefined.");
    }

    // Store the seat class in a member variable for use. Could also be a local variable.
    // My original solution is problematic because it changes the original value of the seat
    // class that was passed into the constructor (you might want that information).
    locSeatClass = seatclass.toUpperCase();

    if (locSeatClass.equals("FIRSTCLASS"))
    { 
      seatchart= new String[FIRSTCLASS/3][3];
      seatlist= new int[FIRSTCLASS/3][3];
      namelist= new String[FIRSTCLASS/3][3];
    }
    else if (locSeatclass.equals("ECONOMY")) { 
      seatchart= new String[ECONOMYCLASS/3][3];
      seatlist= new int[ECONOMYCLASS/3][3];
      namelist= new String[ECONOMYCLASS/3][3];
    }
    else {
        // Throw an exception if someone passes in an unknown seat class string.
        throw new IllegalArgumentException("Unknown seat class detected.")
    }  

}

public void creation() { // NOTE: Java convention is to begin method names with a lower 
                         // case letter.

   // This method is unnecessary. Arrays of integers are initialized with an initial value
   // of zero by default. However, if you want to make your class reusable, you could change
   // change the name of the this method to clear, which would allow you to clear the arrays of
   // an existing object.
   for (int i=0; i< seatlist.length; i++) 
    {  
        for (int j=0; j<seatlist[i].length; j++) 
        { 
            seatlist[i][j]= 0 ;

        }
    }