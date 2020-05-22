while(list != 0)
 {
     list = input.nextInt();

     if(list > max)
     {
        max = list;
        count = 1;         // reset count when new max is found.
     }
     if(list == max)
     {
        count++;
     }
  }