import weblogic.servlet.logging.CustomELFLogger;
import weblogic.servlet.logging.FormatStringBuffer;
import weblogic.servlet.logging.HttpAccountingInfo;

/** 
 * Outputs the session ID specified by the client into a custom field called MyCustomField
 */
public class MyCustomField implements CustomELFLogger {

    public void logField(HttpAccountingInfo metrics, FormatStringBuffer buff) {
        buff.appendValueOrDash(metrics.getRequestedSessionId());
    }
}