final List<Student> origStudentList = Arrays.asList(new Student(
        "B12J9", "Samantha", "Cole"), new Student("A09K2", "Adebisi",
        "Onihan"), new Student(null, "Miguel", "Rodriguez"));

final Gson gson = new GsonBuilder().registerTypeAdapter(Student.class,
        new StudentAdapter()).create();

final String json = gson.toJson(origStudentList);
System.out.println(json);

final List<Student> unmarshalledStudentList = gson.fromJson(json,
        new TypeToken<List<Student>>() {
        }.getType());
System.out.println(unmarshalledStudentList);