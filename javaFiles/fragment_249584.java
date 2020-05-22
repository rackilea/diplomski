import java.lang.management.ManagementFactory;

public class Test {

    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        long vmStartTime = ManagementFactory.getRuntimeMXBean().getStartTime();
        System.out.println(currentTime - vmStartTime);
    }
}