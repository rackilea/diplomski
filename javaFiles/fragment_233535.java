public class CommandFormatValidator {

    private Pattern adlPatternAll = Pattern
            .compile("^ACTV/(READ|ADD|DEL|RPL)/ADL.*");

    private Pattern adlPatternAddDefault = Pattern
            .compile("^ACTV/ADD/ADL/(DFLTTY((/([A-Z0-9]{7})){1,5})|DFLMIN(/[0-9]{1,4}))");

    private Pattern adlPatternDeleteTtymailGeneral = Pattern
            .compile("^ACTV/(DEL|READ)/ADL/TTYMAIL(/[A-Z0-9]{7})?");

    //around 20 more pattern declarations...

    private Pattern[] adlAll = { adlPatternAddDefault
                               , adlPatternDeleteTtymailGeneral
                               //more
                               };

    public void validate(Object payload){
        String command = (String)payload;
        if (! adlPatternAll.matcher(command).matches())
            return;
        for (Pattern p : adlAll)
            if (p.matcher(command).matches())
                return;
        throw new ServiceException(CommandErrors.INVALID_FORMAT);
    }
}