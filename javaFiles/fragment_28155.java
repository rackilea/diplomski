import java.util.ArrayList;

public class BinaryList {

    public static void main(String[] args) {
        try {
            if (args.length != 1 || Integer.parseInt(args[0]) < 1)) {
                System.err.println("Invalid integer argument");
                return;
            }

            binaryRecursive(Integer.parseInt(args[0]), new ArrayList<String>(0));

        } catch (NumberFormatException e) {
            System.err.println("Argument not an integer");
        }
    }

    public static void binaryRecursive(int bits, ArrayList<String> list) {

        if (list.size() == (int)Math.pow(2, bits)) {
            for (String n : list) {
                System.out.println(n);
            }

        } else {
            StringBuilder n = new StringBuilder(bits);

            for (int i = bits - 1; i >= 0; i--) {
                n.append((list.size() >> i) & 1);
            }

            list.add(n.toString());

            binaryRecursive(bits, list);
        }
    }
}