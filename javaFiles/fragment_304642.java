Scanner Scan = new Scanner(System.in);
    int x;
    String Word;
    char Char;
    public Checker()
    {
        System.out.print("Enter The Word ; ");
        Word = Scan.nextLine();
        System.out.print("Enter The character : ");
        Char = Scan.next().charAt(0);
    }

 public void check() {
    for( int  i = 0 ; i < Word.lenght ; i++ )
    {
         char Ch = Word.charAt(i);
         if(Ch == Char )
              x++ ;
    }
     System.out.println(x);
 }
 public static void main(String args[]) {//lets use Checker now to check
    Checker c = new Checker();
    c.check();
 }