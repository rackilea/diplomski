public class StringProblems {
    void shortAndLongWord(String str)
    {
        if (str == null)
            return;
        String sw="",lw="";
        int s=str.length(),l=0;
        String words[]=str.split(" ");
        for(String word:words)
        {
                if(word.length()<s)
                {
                        sw=word;
                        s = word.length();
                }
                if(word.length()>l)
                {
                        lw=word;
                        l = word.length();
                }
        }
        System.out.println("LONGEST WORD : "+lw);
        System.out.println("SHORTEST WORD : "+sw);
    }
    public static void main(String[] args) {
        Scanner scr=new Scanner(System.in);
        StringProblems obj=new StringProblems();
        System.out.printf("Enter a line to get shortest and longest word:");
        String str=scr.nextLine();
        str+=" ";
        obj.shortAndLongWord(str);
    }
}