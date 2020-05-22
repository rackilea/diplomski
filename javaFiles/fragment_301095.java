//...
    String id = matcher.group(1);
    Field valueField = String.class.getDeclaredField("value");
    valueField.setAccessible(true);

    char[] data = ((char[])valueField.get(id));
    System.out.println("Actual data stored for string \"" + id + "\": " + Arrays.toString(data) );