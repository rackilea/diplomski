public class Test {

    public static void main(String[] args) {
    String str = "slugger";

    for(int i=0;i<str.length();i++) {
        stringParser(str.substring(i)); 
    }


    }

    private static void stringParser(String str)
    {
        if(str.length() < 1)
        {
            return;
        }
        else if(str.length() == 0)
        {
            removeFirstChar(str, 1);
        }
        else
        {
            System.out.println(str);
            stringParser(str.substring(0, str.length() - 1));
        }
    }   // End stringParser method

    private static void removeFirstChar(String str, int i)
    {
        String strNew = str.substring(i);
        stringParser(strNew);
        str = strNew;
    } 

}