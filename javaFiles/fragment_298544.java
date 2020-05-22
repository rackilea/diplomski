public class main{
public static void main(String[] args)
{
    String test = "5.3984";
    int tempIndex = 0;

    tempIndex = test.indexOf('.');
    tempIndex =  test.indexOf('.', tempIndex + 1 );
    if (tempIndex != -1)
    {
        System.out.println("multiple periods: " + Float.parseFloat(test.substring(0, tempIndex)));
    }
    else 
    {
        System.out.println("Only one Period: :" + Float.parseFloat(test));
    }
}