import java.util.Scanner; 

class Main {
  public static void main(String[] args) {

    Scanner reader = new Scanner(System.in); 
    System.out.println("Enter three numbers.");  //Use println instead of print, that way the input begins on the next line

    double x = reader.nextDouble();
    double y = reader.nextDouble(); 
    double z = reader.nextDouble();

    if (x >= y){ //In the three responses below, y is always before x.  
            if (y >= z)
                System.out.print("In order " + z + " "+ y + " " + x);

            else if  (z >= x)
                System.out.print("In order " + y + " "+ x + " " + z);

            else if (x > z)
                System.out.print("In order " + y + " " + z + " " + x);
    }

    if (y > x){// In the three responses below, x is always before y
        if (z >= y)
            System.out.print("In order " + x + " " + y + " "+ z);
        else if (z >= x)
            //System.out.print("In order " + y + " " + x + " " + z); //In this case, z has to be smaller than y.  The order was off
            System.out.print("In order " + x + " " + z + " " + y);
        else if (x > z)
            //System.out.print("In order " + y + " " + z + " " + x);
            System.out.print("In order " + z + " " + x + " " + y); //Y is the biggest.  The order here was off.  
    }

  }
}