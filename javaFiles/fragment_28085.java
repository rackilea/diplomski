public class MyObject {

    int[] array = new int[1024*256];

    static List<MyObject> myList = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        while(true){
            myList.add(new MyObject());
        }
    }
}