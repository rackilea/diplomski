EnumMap<StudentAttributes, String> studentOne = new EnumMap<StudentAttributes, String>(StudentAttributes.class);

studentMap.put(StudentAttributes.NAME, "john");
studentMap.put(StudentAttributes.YEAR, "1945");
...
String name = studentMap.get(StudentAttributes.NAME);
String year = studentMap.get(StudentAttributes.YEAR);