Map<String, Object> map = new HashMap<String, Object>();

for (Map.Entry<String, Object> e : map.entrySet()) {
    if (e.getValue() instanceof Integer) {
        // Do Integer things
    } else if (e.getValue() instanceof String) {
        // Do String things
    } else if (e.getValue() instanceof Long) {
        // Do Long things
    } else {
        // Do other thing, probably want error or print statement
    }
}