for (final Iterator<String> iter = errors.keys(); iter.hasNext();) {
    final String key = iter.next();

    try {
        final Object value = errors.get(key);
        final JSONArray error = (JSONArray) value;
        System.out.println(key);
        System.out.println(error.get(0).toString());

    } catch (final JSONException e) {
        // Something went wrong!
    }
}