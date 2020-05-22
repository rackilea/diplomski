Map<String, List<Student>> map = new HashMap<String, List<Student>>();
for (Student student : studlist) {
    String location = student.getLocation();
    List<Student> list = map.get(location);
    if (list == null) {
        list = new ArrayList<Student>();
        map.put(location, list);
    }
    list.add(student);
}