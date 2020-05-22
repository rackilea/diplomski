Scanner input = new Scanner(System.in);
 int a = 0;
 try
 {
    while(true)
    {       
        a = input.nextInt();
        if(a <= 0 || a > 5)
            throw new OutOfRangeException(); //my own Excpt. class
    } 
 }
 catch (OutOfRangeException e) {
    System.out.println(e.getMessage());
 }