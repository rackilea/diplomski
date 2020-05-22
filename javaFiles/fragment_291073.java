public class StringTest
{
  public static void main(String a[])
  {
    System.out.println(testStringBuilder3(null, null, null, null, null));
    System.out.println(testStringBuilder4(null, null, null, null, null));
  }
 public static String testStringBuilder3(String str1, String str2, String str3, String str4, String str5) {
    return str1 + "-" + str2 + "-" + str3 + "-" + str4 + "-" + str5;
  }
  public static String testStringBuilder4(String str1, String str2, String str3, String str4, String str5) {
    return new StringBuilder(str1).append("-").append(str2).append("-").append(str3).append("-").append(str4).append("-").append(str5).toString();
  }
}