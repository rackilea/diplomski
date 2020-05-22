public class Main {
    public static void main(String[] args) {
        //for example ",,"; then the scanner will stop when you input ",,"
        String TERMINATOR_STRING = ",,"

        java.util.Scanner a = new java.util.Scanner(System.in);
        StringBuilder b = new StringBuilder();
        String strLine;
        while (!(strLine = a.nextLine()).equals(TERMINATOR_STRING)) {
            b.append(strLine);
        }
    }
}