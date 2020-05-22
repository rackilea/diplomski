public String GetValue(String key) {
    for (int i = 0; i < length; i++) {
        if (key.equals(keyArr[i])) {
            return valueArr[i];
        }
    }
    return null;
}