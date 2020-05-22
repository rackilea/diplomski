package loggingsscce;

import java.util.logging.Level;
import java.util.logging.Logger;

class LogTestA implements LogTest {
    @Override
    public void doLog() {
        LoggingSSCCE.getLogger(LogTestA.class.getName()).log(Level.INFO, "LogTestA.doLog()");
    }
}