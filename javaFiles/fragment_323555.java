public static void printColValues(Object data) {
    if (data instanceof Map) {
        for (Map.Entry<String, Object> entry : ((Map<String, Object>) data).entrySet()) {
            String key = entry.getKey();
            if (key.startsWith("col")) {
                System.out.println(entry.getValue());
            } else {
                printColValues(entry.getValue());
            }
        }
    } else if (data instanceof List) {
        for (Object obj : (List) data) {
            printColValues(obj);
        }
    }
}