//in Parent.java
package parentpackage;
public class Parent {
    protected String parentVariable = "whatever";// define protected variable
}

// in Children.java
package childenpackage;
import parentpackage.Parent;

class Children extends Parent {
    Children(Parent withParent ){
        System.out.println( this.parentVariable );// works well.
        //System.out.print(withParent.parentVariable);// doesn't work
    } 
}