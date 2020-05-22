/** Beware: Not good for serializing! */
class StdoutStringSink {
    public static final StdoutStringSink INSTANCE = new StdoutStringSink();
    private StdoutStringSink(){}
    @Override
    public void dump(String s){ System.out.println(s); }
}