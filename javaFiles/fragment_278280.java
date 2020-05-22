private String getSomeString() {
    try {
        return getContext().getResources().getString(getContext().getResources().getIdentifier("some_string_identifier", "string", getContext().getPackageName()));
    } catch (Exception e) {
        // Not found, use a default
        return "1234567";
    }
}