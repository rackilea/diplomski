public class MyClass implements Cloneable {

/** some method  ***/

    public Object clone() {  
        try { 
       return super.clone(); 

        } catch (CloneNotSupportedException e) { 

            e.printStackTrace();  
            return null; 
        } 
     } 
}