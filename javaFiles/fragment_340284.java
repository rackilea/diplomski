public static void main(String[] args) 
{
    // TODO code application logic here
    ArrayList<String> artists = new ArrayList<>();
    int mnum = 0, fnum = 0, bnum = 0;
    artists.add("Beyonce (f)");
    artists.add("Drake (m)");
    artists.add("Madonna (f)");
    artists.add("Michael Jackson (m)");
    artists.add("Porcupine Tree (b)");
    artists.add("Opeth (b)");
    artists.add("FallOut Boy (b)");
    artists.add("Rick Ross (m)");
    artists.add("Chris Brown (m)");

    for(String s:artists)
    {
        if(s.indexOf("(b)")!=-1) bnum++;
        if(s.indexOf("(m)")!=-1) mnum++;
        if(s.indexOf("(f)")!=-1) fnum++;
    }

    System.out.println("The number of male artists is: " + mnum);
    System.out.println("The number of female artists is: " + fnum);
    System.out.println("The number of bands is: " + bnum);
}