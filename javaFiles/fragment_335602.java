C:\temp>java foo
false
true

C:\temp>type foo.java
public class foo
{
    public static void main(String[] args)
    {
        String s1 = "ja";
        String s2 = "va";
        String s3 = "ja".concat("va");
        String s4 = "java";
        System.out.println(s3==s4);
        System.out.println(s3.equals(s4));
    }
}