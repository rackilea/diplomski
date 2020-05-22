long thing = 600851475143L;
 for(long i = 0; i < 300425737571L ; i++ ){
     if (i * i > thing) {
       break;
     }
     if (thing % i == 0) {
       long answer = i;
       System.out.println(answer);
       break;
     }
 }