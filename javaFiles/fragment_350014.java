public class AtomicOperation {


     Object lhs;
     Object rhs;
     MyOperator operator;

     AtomicOperation(Object lhs,MyOperator operator, Object rhs) {
         this.lhs = lhs;
         this.rhs = rhs;
         this.operator = operator;
     }

    public Object getLhs() {
        return lhs;
    }
    public void setLhs(Object lhs) {
        this.lhs = lhs;
    }
    public Object getRhs() {
        return rhs;
    }
    public void setRhs(Object rhs) {
        this.rhs = rhs;
    }
    public MyOperator getOperator() {
        return operator;
    }
    public void setOperator(MyOperator operator) {
        this.operator = operator;
    }

     @Override
public String toString() {
        return "(" + lhs.toString() + " " + operator.toString() + " " + rhs.toString() + ")"; 
}

}