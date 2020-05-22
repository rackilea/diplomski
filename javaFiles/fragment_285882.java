int a = 9;
    System.out.println(a);  // just here to prevent some optimization
    if((a = 18) > 15){
        System.out.println(a);
    }


Code:
   0: bipush        9
   2: istore_1
                          // -- removed the System.out.print -- 
  10: bipush        18
  12: dup
  13: istore_1
  14: bipush        15
  16: if_icmple     26