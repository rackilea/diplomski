public class Str1 {

    public static void main(String args[]) {

        try {

            String reverse = "";
            System.out.print("Enter the name of the input file: ");
            Scanner keyboard = new Scanner(System.in);
            String a = keyboard.nextLine();
            File inFile = new File(a);
            Scanner fin = new Scanner(inFile);
            System.out.print("Enter name of the output file: ");
            String outFileName = keyboard.nextLine();
            File outFile = new File(outFileName);
            PrintWriter fout = new PrintWriter(outFile);
            while (fin.hasNext()) {
                String temp = fin.nextLine();
                int length = temp.length();
                for (int i = length - 1; i >= 0; i--)
                    reverse = reverse + a.charAt(i);

                if (a.equals(reverse))
                    fout.println("Entered string is a palindrome.");
                else
                    fout.println("Entered string is not a palindrome.");
            }
            keyboard.close();
            fin.close();
            fout.close();
            System.out.print("Done. See '" + outFileName + "'.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}