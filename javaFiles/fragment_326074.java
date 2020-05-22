public class MyLinkedListTest {

    public static final void main(String[] args) {

        MyLinkedList list = new MyLinkedList();
        System.out.println("Number of items in the list: " + list.size());

        String item1 = "foo";
        String item2 = "bar";

        list.add(item1);
        list.add(item2);

        System.out.println("Number of items in the list: " + list.size());      

        // and so on...
    }

}