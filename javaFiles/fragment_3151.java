public class BigDecimalRenderer extends AbstractRenderer<BigDecimal> {
  private static BigDecimalRenderer INSTANCE;

  public static Renderer<BigDecimal> instance() {
    if (INSTANCE == null) {
      INSTANCE = new BigDecimalRenderer();
    }
    return INSTANCE;
  }

  protected BigDecimalRenderer() {
  }

  public String render(BigDecimal object) {
    if (null == object) {
      return "";
    }

    return NumberFormat.getDecimalFormat().format(object);
  }
}