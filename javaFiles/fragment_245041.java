import java.io.PrintStream;
import java.util.ArrayList;

public class Logger {
    public static void main(String[] args) {
        // creating vehicles
        Vehicle[] vs = { new Vehicle("Bike"), new Vehicle("Car") };

        // adding logs of different type
        vs[0].addLog(new LogTyre("Slim"));
        vs[1].addLog(new LogTyre("Wide"));
        vs[1].addLog(new LogEngine("Lean burn"));

        // maintaining logs
        Logger logger = new Logger();
        for (Vehicle v: vs)
            v.writeLog(logger);

        // printing logs
        for (Vehicle v: vs)
            v.printLogs();
    }
    public void write(Log log) {
        System.out.printf(".. writing to %s.%n", log.name());
        // You may write different logs depending on the log types using common methods
    }
}

class Vehicle {
    String type;            // vehicle type
    ArrayList<Log> logs;    // logs to be maintained
    public Vehicle(String type) {
        this.type = type;
        logs = new ArrayList<Log>();
    }
    public void addLog(Log log) {
        logs.add(log);
    }
    public void writeLog(Logger w)  {
        for (Log log: logs)
            log.accept(w);
    }
    public void printLogs() {
        for (Log log: logs) {
            log.print(System.out);
        }
    }
}

abstract class Log {
    protected String name;  // common fields
    // accepting the visitor
    public void accept(Logger logger) {
        logger.write(this);
    }
    // common methods for maintaining logs
    public abstract String name();
    public void print(PrintStream ps) {
        ps.printf("[Log: %s]%n", name());
    }
}

class LogTyre extends Log {
    public LogTyre(String name) {
        super.name = name;
    }
    public String name() {
        return name+" Tyre Log";
    }
}

class LogEngine extends Log {
    public LogEngine(String name) {
        super.name = name;
    }
    public String name() {
        return name+" Engine Log";
    }
}