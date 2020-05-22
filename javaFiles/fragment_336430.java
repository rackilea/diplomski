import org.beanio.types.IntegerTypeHandler;

public class IntegerToNullTypeHandler extends IntegerTypeHandler {

  /**
   * {@inheritDoc}
   * @see org.beanio.types.IntegerTypeHandler#createNumber(java.lang.String)
   */
  @Override
  protected Integer createNumber(String text) throws NumberFormatException {
    if (text != null && "0".equals(text)) {
      return null;
    }
    return super.createNumber(text);
  }
}