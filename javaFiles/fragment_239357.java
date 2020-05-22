public class Metrics {

    private static Map<String, Integer> metricsMap = new HashMap<>();

    public static int countMetric(String metric) {
        int newValue = metricsMap.compute(metric, 
                                          (s, value) -> value == null 
                                          ? 1 : value + 1);
        return newValue - 1 /* old value */;
    }

    public static void resetMetric(String metric){
        metricsMap.remove(metric);
    }
}