// It is Java convention to have class names capitalized each word
public class RandomFailureQuotes {

    private List<String> quotes = new ArrayList<>();

    // The constructor does not need any arguments since you are 
    // generating the quotes yourself.
    public RandomFailureQuotes() {
        quotes.add("Failure Does't mean the game is over, it means try again with Experience");
        quotes.add("Failure is an event not a person. Yesterday ended Last night - Zig Ziglar");
        quotes.add("We learn from failure not success");
        quotes.add("If you're not prepared to be wrong, you'll never come       up with anything original - Ken Robinson");
    }

    // Because the index and quotes array are member variables, 
    // you do not need the arguments in the method definition. 
    // Also, to get a random number each time you get a quote
    // you will need to move the random variable to the method.
    // you will need to cast the double value of indexPosition to an int                   value 
    public String getQuote() {
        double indexPosition = (Math.random() * 4);
        String quoteToBeDisplayed = quotes.get((int) indexPosition);
        return quoteToBeDisplayed;
    }
}