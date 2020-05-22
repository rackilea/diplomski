public class Counter {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("/Users/myName/Desktop/test.txt"));
        int count = 0;

        String string;
        while (scanner.hasNextLine()) {
            string = scanner.nextLine();
            count++;
        }
        System.out.println(string);
        System.out.println(count);  
   }
}