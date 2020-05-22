public class FileTradeReader implements TradeReader {
    @Override
    public Reader read(String input) {
        return new FileReader(input);
    }
}