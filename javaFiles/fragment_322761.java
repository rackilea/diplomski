public class Program {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new FileReader("B:\\input.txt"));
        String str;
        while ((str = scanner.nextLine()) != null)
            // No need to convert to char array before printing
            System.out.println(str);
    }
}