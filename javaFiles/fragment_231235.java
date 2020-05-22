import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test implements Serializable {

    private static final String FILE = "SaveFile.bin";

    private List<Item> itemList = new ArrayList<>();

    public class Item implements Serializable {
        private String first;
        private String second;
        private String last;
        public Item(String first, String second, String last) {
            this.first = first;
            this.second = second;
            this.last = last;
        }

        @Override
        public String toString() {
            return first + ", " + second + ", " + last;
        }
    }

    public static void main(String args[]) {
        Test test = new Test();
        if(args.length > 0) {
            try {
                test.loadItemList();
                System.out.println("loaded");
                test.printList();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } else {
            test.addItem("1", "2", "done");
            test.addItem("Text", "As", "Example");
            try {
                test.saveItemList();
                System.out.println("saved");
                test.printList();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printList() {
        itemList.forEach(System.out::println);
    }

    private void addItem(String first, String second, String last) {
        itemList.add(new Item(first, second, last));
    }

    private void loadItemList() throws IOException, ClassNotFoundException {
        InputStream inputStream = new FileInputStream(FILE);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        itemList = (List<Item>) objectInputStream.readObject();
    }

    private void saveItemList() throws IOException {
        OutputStream outputStream = new FileOutputStream(FILE);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(itemList);
    }
}