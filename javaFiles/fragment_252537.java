import java.util.regex.Pattern;

public class A
{
  public static void main(String [] args)
  {
      String s = "FROM lineorder A INNER JOIN date B ON (B.d_datekey = A.lo_orderdate)  WHERE (A.lo_discount >= ? AND A.lo_discount <= ?) AND (A.lo_quantity < ?) AND (B.d_year = ?) " ; 

      int [] a =  {1, 3, 25, 1993} ; 

      for(int i : a ) 
      {
        s = s.replaceFirst(Pattern.quote("?"),Integer.toString(i)) ; 
      }

      System.out.println(s) ;      
  }

}