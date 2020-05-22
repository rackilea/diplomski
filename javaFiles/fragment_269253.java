import java.util.ArrayList;
import java.util.Iterator;

class RemoveItemsFromListByContains {
    public static void main(String[] args) {
        // creating an Empty Integer ArrayList
        ArrayList<String> list = new ArrayList<String>();
        list.add("test/te");
        list.add("str1");
        list.add("str2");
        // Print list of items before remove
        System.out.println(list);

        removeItemByContainStr(list, "test");

        // Print list of items after removed
        System.out.println(list);
    }

    private static void removeItemByContainStr(ArrayList<String> list, String containStr) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = (String) iterator.next();
            if (str.contains(containStr)) {
                iterator.remove();
            }
        }
    }
}