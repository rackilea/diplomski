public class GetLocaleByAvailable extends StandardLocaleHandler {

        @Override
        protected Locale getTrueLocale(HttpServletRequest req, HttpServletResponse resp, List<String> localeList, String defaultLocale, Integer cookieAge) {
            Locale result = null;
            if (isNull(req.getSession().getAttribute(LANG_ATTRIBUTE)) && isNull(req.getCookies())) {
                result = setAvailable(req, resp, localeList, defaultLocale, cookieAge);
            }
            if (result == null) {
                StandardLocaleHandler nextHandler = getNext();
                if (nextHandler == null) {
                    return nextHandler.getTrueLocale(....);
                }
            }
            return result;              
        }
    }