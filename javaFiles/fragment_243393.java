public static void main(String args[])
{
    String a = "a; \"b\". c";
    System.out.println("Original string:"+a);

    // split by "

    System.out.println("Split by \"");
    for (String string : a.split("\""))
    {
        System.out.println(string.replaceAll("[.;]", ""));
    } 
}