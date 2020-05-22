public class StringEncoders
{
    static public void main(String[] args)
    {
        System.out.println("hex-url: " + hexUrlEncode("a"));
        System.out.println("hex-html: " + hexHtmlEncode("a"));
        System.out.println("decimal-html: " + decimalHtmlEncode("a"));
    }
    static public String hexUrlEncode(String str)   {
        return encode(str, hexUrlEncoder);
    }
    static public String hexHtmlEncode(String str)  {
        return encode(str, hexHtmlEncoder);
    }
    static public String decimalHtmlEncode(String str)  {
        return encode(str, decimalHtmlEncoder);
    }
    static private String encode(String str, CharEncoder encoder)
    {
        StringBuilder buff = new StringBuilder();
        for ( int i = 0; i < str.length(); i++)
            encoder.encode(str.charAt(i), buff);
        return ""+buff;
    }
    private static class CharEncoder
    {
        String prefix, suffix;
        int radix;
        public CharEncoder(String prefix, String suffix, int radix)        {
            this.prefix = prefix;
            this.suffix = suffix;
            this.radix = radix;
        }
        void encode(char c, StringBuilder buff)     {
            buff.append(prefix).append(Integer.toString(c, radix)).append(suffix);
        }
    }
    static final CharEncoder hexUrlEncoder = new CharEncoder("%","",16);
    static final CharEncoder hexHtmlEncoder = new CharEncoder("&#x",";",16);
    static final CharEncoder decimalHtmlEncoder = new CharEncoder("&#",";",10); 
}