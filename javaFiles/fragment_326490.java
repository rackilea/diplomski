public class TpiCore {

    private static String[] insults = new String[15];
    static {
        insults[0] = "xxx";
        insults[1] = "yyy";
        insults[2] = "zzz";
        // etc...
    }

    public static void main(String[] args) {
        String insult1 = TpiCore.insults[new Random().nextInt(insults.length)];
        System.out.println(insult1);
    }
}