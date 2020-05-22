public abstract class Visitor {
    public abstract void visit( Visitable visitable );

    public abstract Visitor clone();

    public abstract <V extends Visitor> V important();

    public boolean isImportant() {
        //logic to store important visitors
    }
}