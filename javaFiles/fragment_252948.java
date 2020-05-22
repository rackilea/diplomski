import java.io.*;
    class Test1
{
public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        System.out.print("Enter any word: ");
        String s=br.readLine();

        s=s.toUpperCase(); //converting the word into Uppercase
        int l=s.length();
        int pos=-1;
        char ch;

        for(int i=0; i<l; i++)
        {
            ch=s.charAt(i);
            if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U')
            {
                pos=i; //storing the index of the first vowel
                break;
            }
        }

        if(pos!=-1) //printing piglatin only if vowel exists
        {
          String a=s.substring(pos); //extracting all alphabets in the word beginning from the 1st vowel
          String b=s.substring(0,pos); //extracting the alphabets present before the first vowel
          String pig=a+b+"AY"; //adding "AY" at the end of the extracted words after joining them
          System.out.println("The Piglatin of the word = "+pig);
        }
        else
          System.out.println("No vowel, hence piglatin not possible");
    }
}