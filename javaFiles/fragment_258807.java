public abstract class ArrayFuntion {

    public int compute(int[] array) {
        int result = initResult();
        for (int i = 0; i < array.length; i++) {
            result = compute(result, array[i]);
        }
        return result;
    }

    protected abstract int compute(int result, int i);

    protected abstract int initResult();

}


public class Adder extends ArrayFuntion{

    @Override
    protected int compute(int result, int arrayItem) {
        return result + arrayItem;
    }

    @Override
    protected int initResult() {
        return 0;
    }

}


public class Multiplier extends ArrayFuntion {

    @Override
    protected int compute(int result, int arrayItem) {
        return result * arrayItem;
    }

    @Override
    protected int initResult() {
        return 1;
    }

}