public class TpiCore {

    private String[] insults = new String[15];

    public TpiCore() {
        insults[0] = "xxx";
        insults[1] = "yyy";
        insults[2] = "zzz";
        // etc...
    }

    private String randomInsult() {
        return insults[new Random().nextInt(insults.length)];
    }

    public static void main(String[] args) {
        TpiCore core = new TpiCore();
        String insult1 = core.randomInsult();
        System.out.println(insult1);
    }
}