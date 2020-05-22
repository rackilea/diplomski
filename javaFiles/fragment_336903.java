import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Deathstar
 */
public class MyC
{ 

public static void main(String[] args)
{

  BufferedReader br = null;

  boolean isLineMatched = false;
  int c1 = 0, lineNumArrLength, lineCount = 0;
  int lineNums[] = {1,2};
  char[] toCharArr;
  String sCurrentLine, oldText, addSpaces = "";
  String[] valuesToOverwrite = new String[] {"AB","BC","CD"};

    try 
    {

      lineNumArrLength = lineNums.length;

      br = new BufferedReader(new FileReader("C:\\Users\\jtech\\Documents\\NetBeansProjects\\HelpOthers\\src\\textFiles\\Test_File.txt"));

      FileWriter writer1 = new FileWriter("C:\\Users\\jtech\\Desktop\\Test_File1.txt");

      for (int i = 0;i < (valuesToOverwrite.length -1) ;i++ ) //Loop 3 Times
      { 
          writer1.append(valuesToOverwrite[i]+System.lineSeparator()+System.lineSeparator());
      }

      while ((sCurrentLine = br.readLine()) != null )
      {
          oldText = sCurrentLine; 
          lineCount++;        
          isLineMatched = false;      
          toCharArr = sCurrentLine.toCharArray();

          while (c1 < lineNumArrLength) 
          {
              if (lineCount == lineNums[c1])   
              {
                for (int c2 = 0; c2 < toCharArr.length; c2++)
                {
                    if (toCharArr[c2] == ' ')
                    {
                        addSpaces += " ";
                    }
                }
                      String newText = sCurrentLine.replace(oldText, addSpaces+valuesToOverwrite[lineCount]);
                      writer1.append(newText+System.lineSeparator());
                      isLineMatched = true;
                      addSpaces = "";
              } 
              c1++; 

          }

          if (isLineMatched == false)
          {
            writer1.append(oldText+System.lineSeparator());
          }

          c1 = 0;
      }




      writer1.close();


    } 
    catch (IOException e) 
    {
      e.printStackTrace();
    } 
    finally 
    {
      try 
      {
        if (br != null)
        {
              br.close();
        }
      } 
      catch (IOException ex) 
      {
        ex.printStackTrace();
      }
    }    
  }        

}