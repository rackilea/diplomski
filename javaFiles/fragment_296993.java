public static List<Person> filter(List<Person> source, String fieldToParse, String value) {
    // Field getter
    Method fieldGetter = null;
    try {
        fieldGetter = Person.class.getMethod("get" + firstUpperCase(fieldToParse));
    } catch (NoSuchMethodException ex) {
        throw new IllegalArgumentException("Invalid field name: " + fieldToParse);
    }

    // Filter
    List<Person> list = new ArrayList<Person>();
    for (Person person : source) {
        try {
            Object obj = fieldGetter.invoke(person);
            //TODO: process NULL here
            if (obj.equals(value)) {
                list.add(person);
            }
        } catch (Exception e) {
        }

    }
    return list;
}

public static String firstUpperCase(String str) {
    if (str == null) {
        return null;
    }
    if (str.isEmpty() == false) {
        char[] chars = str.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return new String(chars);
    }
    return str;
}