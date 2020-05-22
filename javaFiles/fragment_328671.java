public class StubTradeReader implements TradeReader {
    @Override
    public Reader read(String input) {
        return new StringReader(input);
    }
}