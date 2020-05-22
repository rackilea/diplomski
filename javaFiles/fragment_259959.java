import java.util.ArrayList;
import java.util.List;

public class arr {
    List<Integer> alpha = new ArrayList<>(); 

    //creates the isEmpty method 
    boolean isEmpty() {return alpha.isEmpty();}

    //check if two arr classes are the same
    @Override
    public boolean equals(Object obj) {
       if (obj == this)   return true; 
       if (obj == null || obj.getClass() != this.getClass())   
           return false; 

       arr other = (arr) obj;
       //checks if the alpha of this is the same as the alpha in obj
       return  alpha.equals(other.alpha);
    }

    //also override the hashCode method so that it'll work correctly for hash containers like hashMap and hashSet.
    @Override
    public int hashCode(){ return alpha==null?0: alpha.hashCode(); }

    public static void main (String []args ) {
        arr com1 = new arr();
        arr com2= new arr();

       //calling the isEmpty() method from the main.
       System.out.println("com1 Empty? =" +com1.isEmpty());
       //checks if com1 and com2 are equal
       System.out.println("com1 same as com2? =" +com1.equals(com2));
    }

}