StringBuilder builder = new StringBuilder() ;
builder.append('{');
Enumeration keys = props.keys();
while (keys.hasMoreElements()) {
  String key = (String)keys.nextElement();
  String value = (String)props.get(key);
  builder.append('"').append(key).append('"');
  builder.append(':');
  builder.append('"').append(value).append('"').append(',');
}
builder.deleteCharAt(builder.length()-1);
builder.append('}');
String json = builder.toString();