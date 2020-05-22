package loggingsscce;

import java.util.logging.Level;
import java.util.logging.Logger;

class LogTestB implements LogTest {
    @Override
    public void doLog() {
        LoggingSSCCE.getLogger(LogTestB.class.getName()).log(Level.INFO, "LogTestB.doLog()");
    }
}