String[] strings = {"Java", "is", "cool"};
StringBuilder builder = new StringBuilder();

for (String string : strings) {
    if (builder.length() > 0) {
        builder.append(" ");
    }
    builder.append(string);
}

String string = builder.toString();
System.out.println(string); // Java is cool