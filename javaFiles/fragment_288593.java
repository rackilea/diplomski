Map<String, String> map = new HashMap<>();
map.put("§", "0");
...

String toChar = map.get(curChar);
if (toChar!=null) ((JButton) getButtons().get(i)).setText(toChar);