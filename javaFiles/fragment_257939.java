public class num {
public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    getFile(list);
System.out.println("numbers are: " + list);
}

public static void getFile(ArrayList<Integer> list) {


    try {
        Scanner read = new Scanner(new File("numbers.txt"));

        do {
        list.add(read.nextInt());


        }while (read.hasNext());



    } catch (FileNotFoundException fnf) {
        System.out.println("File was not found");
    }

}