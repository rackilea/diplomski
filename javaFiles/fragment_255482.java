public class Main {

    public static void main(String[] args) {
        Student student = getStudent("john=John Appleseed");
        System.out.println(student.fullName);
    }

    public static Student getStudent(String myQuery) {
        return returnQueryColumn(myQuery);
    }

    private static Map<String, Student> returnMap(String myQuery){
        String[] params = myQuery.split("=");
        Map<String, Student> myMap = new HashMap<String, Student>();
        String myKey = params[0];
        String myValue = params[1];
        Student student = new Student(myValue);
        myMap.put(myKey, student);

        return myMap;
    }

    private static Student returnQueryColumn(String myQuery) {
        String[] params = myQuery.split("=");
        String key = params[0];
        return returnMap(myQuery).get(key);
    }
}