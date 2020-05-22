public class Leg {

    Body parent;

    public Leg(Body parent) {
        this.parent = parent;
    }

    public void move() {
        if(parent.isStanding()) // PROBLEM:  no access to body
            ; // <extend details>
    }

}