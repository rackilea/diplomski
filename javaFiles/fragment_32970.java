StringBuilder sb = new StringBuilder(textNode.getText());

for(Entry<Date, String> entry : tmap.entrySet()) {
    Date key = entry.getKey();
    String value = entry.getValue();

    sb.append(key).append(" => ").append(value).append('\n');
    ...
}
textNode.setText(sb.toString());