class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println(checkVal("Imhereman", "Imaereads", 5));
        // your code goes here
    }
    public static Boolean checkVal(String s1, String s2, int n)
    {
        System.out.println("comparing '" + s1 + "' and '" + s2 + "' with n = " + n + " matches to go");
        if(n == 0) return true;
        if(s1.length() == 0 || s2.length() == 0) return false;
        if(s1.charAt(0) == s2.charAt(0)) n--;
        return checkVal(s1.substring(1), s2.substring(1), n);
    }
}