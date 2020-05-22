public interface TransactionDataExtractor<E> {
    public TransactionData extract(E source); 
} 

public class TransactionDataExtractorRequest 
    implements TransactionDataExtractor<HttpServletRequest> {
    public TransactionData extract(HttpServletRequest source) { ... }
}