import java.lang.reflect.*;
import java.util.*;

class Value {}

class IntValue extends Value {
    private int value;
    public int value() {
        return value;
    }
    public IntValue(int value) {
        this.value = value;
    }
    public String toString() {
        return String.valueOf(value);
    }
}

class StringValue extends Value {
    private String value;
    public String value() {
        return value;
    }
    public StringValue(String value) {
        this.value = value;
    }
    public String toString() {
        return value;
    }
}

class Operator {
    public Value apply(Value x, Value y) throws ArithmeticException {
        try {
            var method = this.getClass().getDeclaredMethod("apply", x.getClass(), y.getClass());
            return (Value) method.invoke(this, x, y);
        } catch (InvocationTargetException exception) {
            throw (ArithmeticException) exception.getCause();
        } catch (Exception ignore) {
            return null;
        }
    }

    private IntValue apply(IntValue x, IntValue y) {
        return new IntValue(x.value() / y.value());
    }

    private StringValue apply(StringValue x, StringValue y) {
        return new StringValue(x.value() + y.value());
    }
}

public class Main {
    public static void main(String[] args) {
        var op = new Operator();

        System.out.println(op.apply(new IntValue(6), new IntValue(2)));
        System.out.println(op.apply(new StringValue("a_str"), new StringValue("b_str")));

        try {
            System.out.println(op.apply(new IntValue(6), new IntValue(0)));
        } catch (ArithmeticException exception) {
            exception.printStackTrace();
        }
    }
}