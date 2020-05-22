public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        Pattern p = Pattern.compile("\\s+key.+");

        Scanner sc = new Scanner(new File("src/main/resources/test.txt"));
        while (sc.hasNextLine()) {
            sc.nextLine();
            String theLineYouWant = sc.findInLine(p);
            // scnn this line again here
            if (theLineYouWant != null) {
                System.out.println(theLineYouWant);
            }
        }
    }
}