@Named("customLoggingFilter")
public class CustomLoggingFilter extends TurboFilter {

    @Autowired
    private TestService ts;

    @Override
    public FilterReply decide(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {
        System.out.println(ts.doTest());
        return FilterReply.ACCEPT;
    }
}