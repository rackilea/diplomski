byte[] bytes = input.getText().getBytes("UTF-8");

StringBuilder sb = new StringBuilder(2 * bytes.length);
for (byte b : bytes) {
    sb.append("0123456789ABCDEF".charAt((b & 0xF0) >> 4));
    sb.append("0123456789ABCDEF".charAt((b & 0x0F)));
    sb.append("-"); // place "-" between each conversion
}
sb.deleteCharAt(sb.length() - 1); // remove trailing "-"
String hex = sb.toString();

output.setText("Text area UTF-8 in hex: " + hex);