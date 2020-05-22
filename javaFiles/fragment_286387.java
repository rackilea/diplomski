import java.util.logging.ConsoleHandler;
import java.util.logging.Loggger;
import java.util.logging.LogManager;

...

System.setErr(otherStream);

try {
    LogManager.getLogManager().readConfiguration();
}
catch(java.io.IOException e) {
    // ...
}

Logger.getGlobal().addHandler(new ConsoleHandler());