public interface Strategy {
    public Object[] execute(Object[] args);
}

public class StrategyFactory {

    public enum Name {
        REVERSE, STRINGIFY, DUPLICATE;
    }

    private StrategyFactory() {
        // never instantiate; only use static factory methods
    }

    public static Strategy getStrategyReverse() {
        return new Strategy() {
            public Object[] execute(Object[] args) {
                Object[] reversed = new Object[args.length];
                for (int i = 0; i < args.length; i++) {
                    reversed[i] = args[args.length - i - 1];
                }
                return reversed;
            }
        };
    }

    public static Strategy getStrategyStringify() {
        return new Strategy() {
            public Object[] execute(Object[] args) {
                String[] stringified = new String[args.length];
                for (int i = 0; i < args.length; i++) {
                    stringified[i] = String.valueOf(args[i]);
                }
                return stringified;
            }
        };
    }

    public static Strategy getStrategyDuplicate() {
        return new Strategy() {
            public Object[] execute(Object[] args) {
                Object[] duplicated = new Object[2 * args.length];
                for (int i = 0; i < args.length; i++) {
                    duplicated[i * 2] = args[i];
                    duplicated[i * 2 + 1] = args[i];
                }
                return duplicated;
            }
        };
    }

    public static Strategy getStrategy(String name) {
        return getStrategy(Name.valueOf(name));
    }

    public static Strategy getStrategy(Name name) {
        switch (name) {
            case REVERSE:
                return getStrategyReverse();
            case STRINGIFY:
                return getStrategyStringify();
            case DUPLICATE:
                return getStrategyDuplicate();
            default:
                throw new IllegalStateException("No strategy known with name " + name);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Strategy strategy = StrategyFactory.getStrategy("DUPLICATE");
        System.out.println(Arrays.toString(strategy.execute(args)));
    }
}