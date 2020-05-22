if (!text.isEmpty()) {
    int p = Integer.parseInt(text);
    int i = (p * 5);
    String s = String.valueOf(i);
    field1.setText(s);
} else {
    field1.setText(null);
}