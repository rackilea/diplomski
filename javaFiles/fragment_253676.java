for (Entry<String, ?> key : appPrefs.getAll().entrySet()) {
    Object result = key.getValue();
    if (result instanceof Boolean) {
        //handle boolean
    } else if (result instanceof String) {
        //handle String
    }
    findPreference(key.getKey()).setSummary(result);
}