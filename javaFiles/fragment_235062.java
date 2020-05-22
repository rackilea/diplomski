public class Countletter 
 {
    public static void main(String args[]) throws IOException
    {        
      String str = "muhammed"; 
      char[] Array = str.toCharArray();

     for(int i=0;i<8;i++)
     {
         if(Array[i]!=' '){
          int count=1;
           for(int j=i+1;j<8;j++)
           {
            if(Array[i]==(Array[j]))
            {
             count++;
             Array[j]=' ';
            }
          }
        System.out.println(""+Array[i]+":"+count);
       }
    }
  }
}