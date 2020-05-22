final class A
{
     private static int[] manualpointx = {135,200,300,155,235,300};
     private static List<Point> manualpoint = new ArrayList<Point>();

     public static int[] returnArray()
     {
          return(manualpointx);   
     }

     public static List<Point> returnList()         
     {
          return(manualpoint);
     }

}
public class DrawView extends View implements OnTouchListener
{ 
    @Override
    public void onDraw(Canvas canvas) 
    {
         //pass the values into this class
         int arr[]=A.returnArray();
         List<Point> list=A.returnList();
    }
}