public final class CustomRule extends NormalRule {

    public CustomRule(RedirectType redirectType, MatchType matchType, String from, String to) {
        super();

        setMatchType(matchType);
        setToType(redirectType);

        setFrom(from);
        setTo(to);
        setQueryStringAppend("true");
    }

    @Override
    public boolean initialise(ServletContext context) {
        super.initialise(context);
        return true;
    }

}