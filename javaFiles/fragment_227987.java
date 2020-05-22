import org.bouncycastle.crypto.generators.SCrypt;
public static void ScryptSpringFramework()
{   
    public static String plaintextPassword  = "myname123456";
    SCryptPasswordEncoder sEncoder = new SCryptPasswordEncoder();

    String str1 = sEncoder.encode(plaintextPassword);
    System.out.println("SpringFramework output of "+plaintextPassword+" = "+str1);              
}