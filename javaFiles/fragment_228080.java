public class SpecialMessageSource extends ReloadableResourceBundleMessageSource {

      @Override
      protected MessageFormat resolveCode(String code, Locale locale) {
         MessageFormat result = super.resolveCode(code, locale);
         if (result.getPattern().isEmpty() && locale == Locale.CHINESE) {
            return super.resolveCode(code, Locale.ENGLISH);
         }
         return result;
      }

      @Override
      protected String resolveCodeWithoutArguments(String code, Locale locale) {
         String result= super.resolveCodeWithoutArguments(code, locale);
         if ((result == null || result.isEmpty()) && locale == Locale.CHINESE) {
            return super.resolveCodeWithoutArguments(code, Locale.ENGLISH);
         }
         return result;
      }
   }