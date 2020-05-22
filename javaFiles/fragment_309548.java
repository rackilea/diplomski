public int getName(EditText name) {
    int match = 1;
    String text = name.getText().toString();
    for (int o = 0; o < uNamesList.size(); o++) {
        String uName = (String)uNamesList.get(o);
        if (text.equals(uName)) {
            return o;
        }
    }
    return match;
}