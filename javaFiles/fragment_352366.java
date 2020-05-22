public class MyCSVMapper  
{    
    String[] fields = {"First","Second","Third"};    

    public String toCSV()  
    {  
          String formatted = "";    
          for(int i = 0; i < formatted.length;i++)
          {
             if(i == formatted.length-1)  
             {  
                formatted+=formatted[i];
                break;  
             }  
              formatted+=formatted[i]+",";
          }  
          return formatted;  
    }  
}