class SO15933038 
{

    private static int[] hexStringToIntArray(String s) 
    {
        int len = s.length();
        int[] data = new int[len / 2];
        for (int i=0; i<len; i+=2) {
            data[i / 2] =  ((Character.digit(s.charAt(i), 16) << 4)
                           + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    private static String intArrayToHexString(int[] a)
    {
        StringBuilder sb = new StringBuilder(a.length);
        for (int i=0; i<a.length; i++)
        {
            sb.append((char) a[i]);
        }
        return sb.toString();
    }

    public static String Decrypt(String encrypted, int key1, int key2, int key3)
    {
        int[] input = hexStringToIntArray(encrypted);
        int[] output = new int[input.length];
        for (int i=0; i<output.length; i++)
        {
            output[i] = input[i]^(key1>>8) & 0xff;
            key1 = ((input[i]+key1)*key2+key3) & 0xffff;
        }
        return intArrayToHexString(output);
    }

    public static void main(String[] args) 
    {
        System.out.println(Decrypt("41db791e06a9", 111, 222, 333));
    }
}