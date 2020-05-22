public class Response
{
    private Query query;

    public Query getQuery()
    {
        return query;
    }

    public void setQuery(Query query)
    {
        this.query = query;
    }

}

class Query 
{
    private int count;
    private Results results;
    public int getCount()
    {
        return count;
    }
    public void setCount(int count)
    {
        this.count = count;
    }
    public Results getResults()
    {
        return results;
    }
    public void setResults(Results results)
    {
        this.results = results;
    }


}

class Results
{
    private Quote quote;

    public Quote getQuote()
    {
        return quote;
    }

    public void setQuote(Quote quote)
    {
        this.quote = quote;
    }


}

class Quote
{
    private String symbol;

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }
}