...
public class Test {
    private static ArrayList tricky(ArrayList<String> list) {
        list.add(12345); //Error, couldn't add Integer to String
        return list;
    }
...
}