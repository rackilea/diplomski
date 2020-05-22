IntStream.range(0, 5).peek(i->{
         if(i<3) {
             System.out.println(i);
         }

     }).filter(j->j>=3).findFirst();