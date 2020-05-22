public enum Mode 
{
    EASY,
    HARD,
}

public enum Category 
{
    SPORTS,
    POLITICS,
}

public abstract class QuoteFactory 
{
    public QuoteFactory getQuoteFactory(final Mode mode)
    {
        // return either the Hard or Easy QuoteFactory
    }

    public abstract Quoute getQuote(Category category)
}

class HardQuoteFactory
    extends QuoteFactory
{
    public Quote getQuote(final Category category)  
    {
         // ...
    }
}

class EasyQuoteFactory
    extends QuoteFactory
{
    public Quote getQuote(final Category category)  
    {
         // ...
    }
}