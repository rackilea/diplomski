Map<IntTuple, List<Student>> map = new HashMap<IntTuple, List<Student>>();

List<Student> students = new ArrayList<Student>();

map.put(IntTuple.of(1,2,3), students);

List<Student> s = map.get(IntTuple.of(1,2,3));