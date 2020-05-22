@Singleton
@Startup
public class QuoteFetcher {

     private List<Quote> quotes; // + getter

     @PostConstruct
     public fetchQuote()
          quotes = SomeUrlBuilder.someUrl().getQuotes();
     }
 }