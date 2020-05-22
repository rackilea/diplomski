public class AddOp implements IOperation{

    private int a;
    private int b;
    private int c;

    public AddOp(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public void execute(Executor ex) {
        this.c = this.a + this.b;
        ex.executeAddOp(this);
    }
}

public class Executor {
    public void executeAddOp(AddOp op) {
        System.out.println("Executing an AndOp... " + op);
    }
}