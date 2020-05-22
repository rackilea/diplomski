abstract class Operand {
    public abstract <T extends Operand> Operand operation(Operator operator, T operand);
}

abstract class Numeric<T extends Numeric<T>> extends Operand {
    public abstract Operand operation(Operator operator, T operand);
}

class Integer extends Numeric<Integer> {

    @Override
    public Operand operation(Operator operator, Integer operand) {
        // add your Integer specific code here
        return null; // replace null with actual returned value
    }

    @Override
    public <T extends Operand> Operand operation(Operator operator, T operand) {
        // simply call to overridden Integer specific method
        // no harm to downcast it here
        return operation(operator, (Integer) operand); 
    }

}