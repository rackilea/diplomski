public class CmdLine {

    public static void main(String args[]) {
        String p = "";
        int i = 0;

        for (int k = 0; k < args.length; k++) {
            if (args[k].equals("-name")) {
                p = args[k + 1];
            } else if (args[k].equals("-c")) {
                i = Integer.parseInt(args[k + 1]);
            }
        }

        for (int j = 0; j < i; j++) {
            System.out.println("Hello " + p + "!");
        }
    }
}