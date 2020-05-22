for (int lineOne=1; lineOne<=16; lineOne += 2){
    System.out.print("//");
                                                 }
    for (int lineOne1=1; lineOne1<=32; lineOne1 += 2){
    System.out.print("\\");
       }
    System.out.println("");
    for (int a=8; a<=32; a += 8)
      {
    for (int b=12; b < 28-a/2; b +=2)
    {
        System.out.print("//");
    }
    for (int c=0; c<a; c++)
    {
        System.out.print("*");

    }

    // this prints your "\\"
    for(int k = 0;k<16-a/2;k++) 
    {
     System.out.print("\\");   
    }

    System.out.println(" ");

}