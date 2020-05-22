public class TestToString {
    public static void main(String[] args) {
        TestToString tts = new TestToString ();
        System.out.println(tts);
        System.out.println(tts.superToString());
    }

    public String superToString()
    {
        return super.toString ();
    }

    @Override
    public String toString()
    {
        return getClass().getName()+"@"+Integer.toHexString(hashCode());
    }
}