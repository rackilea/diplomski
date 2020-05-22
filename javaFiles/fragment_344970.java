public abstract class ParentClass<T extends ParentVariable>
{
    private T variable;

    protected T getVariable(){
        return variable
    }

    protected void setVariable(T variable){
        this.variable = variable;
    }
    ....
}

public class ChildClass extends ParentClass<ChildVariable>
{
    public ChildClass() {
        setVariable(new ChildVariable());
        //Where ChildVariable Extends ParentVariable
        ChildVariable foo = getVariable() // no cast nessecary
    }
}