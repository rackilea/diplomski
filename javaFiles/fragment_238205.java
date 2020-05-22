public class Class {

    int variableFromAnotherClass;

    public void getVar() {
        return variableFromAnotherClass;
    }

    public int setVar(int var) {
        this.variableFromAnotherClass = var;
    }

}