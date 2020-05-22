import org.slf4j.MDC;

public class Main {
    public static void main(String... args) {
        // put process ID early
        MDC.put("process_id", 
            ManagementFactory.getRuntimeMXBean().getName());
    }
}