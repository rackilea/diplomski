String[] numbers = s.split("[[+-/*]&&[^.]]");

ArrayList<String> ops = new ArrayList<String>();
for (String op : s.split("[^*/+-]"))
    if (!op.isEmpty())
        ops.add(op);
String[] operators = ops.toArray(new String[0]);