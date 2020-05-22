public class CurrencyUtil
 {
  public static BigDecimal currencyUtil(
                RenderRequest renderRequest, 
                RenderResponse renderResponse,
                String amountStr) throws IOException, PortletException 
    {
       BigDecimal amount = new BigDecimal(amountStr); 
       ...
    }
 }