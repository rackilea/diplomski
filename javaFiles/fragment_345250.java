class StrategyExample {


    public static void main(String[] args) {

        Context context;

        // Two contexts following different strategies
        context = new Context(new ConcreteStrategyNumber());
        string numberedText = context.executeStrategy(text);

        context = new Context(new ConcreteStrategyLetter());
        string letteredText = context.executeStrategy(text);

    }
}