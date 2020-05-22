public static void printColValues(Object data) {
    if (data instanceof Map) {
        for (Map.Entry<String, Object> entry : ((Map<String, Object>) data).entrySet()) {
            Object value=entry.getValue();
            if (value instanceof String) {
                System.out.println(value);
            } else {
                printColValues(value);
            }
        }
    } else if (data instanceof List) {
        for (Object obj : (List) data) {
            printColValues(obj);
        }
    }
}