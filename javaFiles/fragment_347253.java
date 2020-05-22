for (int i = 0; i < 3; i++) {
    String fieldName = "line" + i;
    Field lineField = Globe.class.getDeclaredField(fieldName);
    int[] line = lineField.get(null); // null for static fields
    System.out.println(Arrays.toString(line));
}