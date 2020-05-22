public class Counting100PostMethod extends PostMethod {
Logger log = Logger.getLogger(Counting100PostMethod.class);
boolean first100 = true;

public Counting100PostMethod() {
    super();
}

public Counting100PostMethod(String s) {
    super(s);
}

@Override
protected void processStatusLine(HttpState httpState, HttpConnection httpConnection) {
    super.processStatusLine(httpState, httpConnection);
    int status = getStatusCode();
    if (status == 100) {
        if (first100) {
            first100 = false;
        } else {
            // can now increment counter
            log.debug("Increment counter");
        }
    }
}