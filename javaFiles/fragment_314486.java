public class test2 {

    public static void main(String ... args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("123");
        myList.add("245");
        myList.add("678");
        ListIterator<String> iter = myList.listIterator();
        while(iter.hasNext()){
            String url = (String) iter.next();
            System.out.println(url);
        }
}