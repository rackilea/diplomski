import java.util.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        ArrayList<String> testList = new ArrayList<String>(); 
        String s1 = new String ("ACCEPTED");
        String s2 = new String ("OK");
        String s3 = new String ("NOT OK");


        testList.add(s1);
        testList.add(s2);
        testList.add(s3);


        String status= "";

        if(testList.contains("ACCEPTED")) {
             status= "ACCEPTED";
        }
        else if(testList.contains("OK")) {
            status= "OK";
        } 
          else {
            status= "NOT OK";
         }
        System.out.println(status);

    }
}