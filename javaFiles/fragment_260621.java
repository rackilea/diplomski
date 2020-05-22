public static void main (String[] args) throws java.lang.Exception
{
     String s = "HÃ¤r har du!  â\u0080\u0093 Hur vÃ¤l kan du snacka?";        
     byte[] bytes = s.getBytes("ISO-8859-1");
     String str  = new String(bytes, "UTF-8");
     System.out.println(str);
}