static char[][] getArrayBack(Context context) {
    final SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.domain.project.SharedPrefName", Context.MODE_PRIVATE);
    final String json = sharedPreferences2.getString("com.domain.project.arrayName", null);

    try {
        return parseNestedArrays(json);
    } catch (JSONException e) {
        return null;
    }
}

static char[][] parseNestedArrays(String input) throws JSONException {
    final JSONArray array = new JSONArray(input);
    final char[][] result = new char[array.length()][];

    for (int i = 0; i < array.length(); i++) {
        final JSONArray subarray = array.getJSONArray(i);
        final char[] subresult = new char[subarray.length()];
        for (int j = 0; j < subarray.length(); j++) {
            subresult[j] = subarray.getString(j).charAt(0);
        }
        result[i] = subresult;
    }

    return result;
}