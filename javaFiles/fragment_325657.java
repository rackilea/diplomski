package validation;

 import java.util.Locale;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;
 import javax.validation.MessageInterpolator;
 import javax.validation.Validation;

 public class MyInterpolator implements MessageInterpolator{
    private MessageInterpolator interpolator;

    public MyInterpolator() {
        //we need to delegate to the default interpolator
        this.interpolator = Validation.byDefaultProvider().configure().getDefaultMessageInterpolator();
    }

    private static final Pattern parametersPattern=Pattern.compile("\\[(.+)\\]$");

    protected static String replaceParameters(String message){
        Matcher matcher = parametersPattern.matcher(message);
        String values[]={};
        if(matcher.find()){
            values=matcher.group(1).split("\\s*,\\s*");
            message=message.substring(0, matcher.start());
            for(int i=0; i < values.length; i++){
                message=message.replace("{"+i+"}", values[i]);
            }
        }
        return message;
    }

    @Override
    public String interpolate(String messageTemplate, Context context) {
        String message = interpolator.interpolate(messageTemplate, context);
        return replaceParameters(message);
    }

    @Override
    public String interpolate(String messageTemplate, Context context, Locale locale) {
        String message = interpolator.interpolate(messageTemplate, context);
        return replaceParameters(message);
    }

}