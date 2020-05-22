public static boolean replaceVariables(Properties properties) {
        boolean changed = false;
        for (Entry<Object, Object> entry : properties.entrySet()) {
            if (entry.getValue() instanceof String) {
                String value = (String) entry.getValue();
                value = value.trim();
                if (value.startsWith("${") && value.endsWith("}")) {
                    value = System.getProperty(value.substring(2, value.length() - 1));
                    if (value == null)
                        entry.setValue("");
                    else
                        entry.setValue(value);
                    changed = true;
                }
            }
        }
        return changed;
    }