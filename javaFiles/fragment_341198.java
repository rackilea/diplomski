import java.util.Vector;

class vector1 { //classes should be capitalized

    Vector  first   = new Vector();

    public void name() { //methods must have a return type 
                         //(even if it's void) and must have input parameters between ()

        int a = 1; //java statements end with ;
        Vector last = new Vector(); //java statements end with ;        

//      int num1 = ((vector1) last.elementAt(a)).first.size();

        /*
         * this is the same as
         */     

        Object lastElement = last.elementAt(a); //this is the second element from "last" 
                                                //because the first element's index is 0 
                                                //Since "last" is empty, you'll get an error here

        vector1 v = (vector1)lastElement; //now you're forcing the compiler to assume that lastElement is a Vector
        Vector v2 = v.first;              //now you're getting vector's attribute "first", which is another Vector
        int num1 = v2.size();             //now you're calling the method size() on v.first to get the vector number of elements
    }
}