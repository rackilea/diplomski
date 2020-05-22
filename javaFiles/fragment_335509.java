public class count {
    public static void main(String[] args) {
        int positive = 0;
        for (int i = 0; i < args.length; i++) {
            if (Integer.parseInt(args[i]) > 0) {
                positive++;
            }
        }
        System.out.println(positive);
    }
}