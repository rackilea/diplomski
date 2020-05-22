import  java.io.File;
   import  java.io.IOException;
   import  java.util.regex.Pattern;
   import  org.apache.commons.io.FileUtils;
   import  org.apache.commons.io.LineIterator;
   import  xbn.io.RTIOException;
/**
   <P>Prints the start and end line-numbers for all JavaDoc blocks in a Java source-code file. The one and only parameter is the path to the file. This assumes that the JavaDoc open-comment (slash-asterisk-asterisk) is the first non-whitespace on its line. The end comment (asterisk-slash) may be anywhere on the line.</P>

   java PrintJDBlocksStartStopLineNumsXmpl C:\java_code\PrintJDBlocksStartStopLineNumsXmpl.java
 **/
 public class PrintJDBlocksStartStopLineNumsXmpl  {
    /**
       <P>The main function.</P>
     **/
    public static final void main(String[] as_1RqdJavaSourcePath)  {

       //Read command-line parameter
          String sJPath = null;
          try  {
             sJPath = as_1RqdJavaSourcePath[0];
          }  catch(ArrayIndexOutOfBoundsException aibx)  {
             throw  new NullPointerException("Missing one-and-only required parameter: Path to java source-code file.");
          }
          System.out.println("Java source: " + sJPath);

       //Establish line-iterator
          LineIterator li = null;
          try  {
             li = FileUtils.lineIterator(new File(sJPath)); //Throws npx if null
          }  catch(IOException iox)  {
             throw  new RTIOException("PrintJDBlocksStartStopLinesXmpl", iox);
          }
          Pattern pTrmdJDBlockStart = Pattern.compile("^[\\t ]*/\\*\\*");

       String sDD = "..";
       int iLn = 1;
       boolean bInJDBlock = false;
       while(li.hasNext())  {
          String sLn = li.nextLine();
          if(!bInJDBlock)  {
             if(pTrmdJDBlockStart.matcher(sLn).matches())  {
                bInJDBlock = true;
                System.out.print(iLn + sDD);
             }
          }  else if(sLn.indexOf("*/") != -1)  {
             bInJDBlock = false;
             System.out.println(iLn);
          }
          iLn++;
       }
       if(bInJDBlock)  {
          throw  new IllegalStateException("Reach end of file. JavaDoc not closed.");
       }
    }
    /**
       <P>Another one</P>
     **/
    private static final void oneMoreForGoodMeasure()  {
    }
}