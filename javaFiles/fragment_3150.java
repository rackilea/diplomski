public class BigDecimalBox extends ValueBox<BigDecimal> {
  public BigDecimalBox() {
    super(Document.get().createTextInputElement(), BigDecimalRenderer.instance(),
        BigDecimalParser.instance());
  }
}