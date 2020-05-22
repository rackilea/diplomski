public static void main(String[] args) {

System.out.print ("Enter your text: \n");

try(Scanner input=new Scanner(System.in)) {

    String str=input.nextLine();

    int ch=0;
    int nlines=0;
    int nwords=0;

    boolean stopCount = false;
    while(true)
    {
        if(str.contains(".")) {
            String[] split = str.split(".");
            if(split.length > 1) {
                str = split[0];
                break;
            }
            stopCount = true;
        }

        ch+=str.replace(" ", "").length();
        nlines++;
        String[] words = str.split(" "); 
        nwords += words.length;

        if(stopCount) {
            break;
        }

        str=input.nextLine();
    }

    System.out.println("Number of words :"+nwords);
    System.out.println("Number ofcharacters: "+ch);
    System.out.println("Number of lines: "+nlines);
    }

}