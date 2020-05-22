public static Map<String, Object> mapWithKeysAndObjects(Object... objects) {

    if (objects.length % 2 != 0) {
        throw new IllegalArgumentException(
                "The array has to be of an even size - size is "
                        + objects.length);
    }

    Map<String, Object> values = new HashMap<String, Object>();

    for (int x = 0; x < objects.length; x+=2) {
      values.put((String) objects[x], objects[x + 1]);
    }

    return values;

}