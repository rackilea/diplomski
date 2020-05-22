public class HelloWorld
{
    static String[] month = new String[]{"1","2","3","4","5","6","7*","8","9*"};
    public static boolean isSignificant() 
        {
            boolean isFound = false;
            for(int i=0; i <month.length && isFound == false; i++)
                {
                    if(month[i].endsWith("*")) 
                        {
                            isFound = true;
                        }
                }
            return isFound;
        }

    public static void main(String []args)
        {
            HelloWorld obj = new HelloWorld();
            if(obj.isSignificant())
                {
                    System.out.println("The string ends with *");
                }
            else
                {
                    System.out.println("The string donot end with *");
                }
        }
}