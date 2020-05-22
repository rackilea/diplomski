int randomIndex=0,randomIndex2 =0,randomIndex3 =0;   //declare global 


randomIndex = new Random().nextInt(qs2.length);

do{
  randomIndex2 = new Random().nextInt(qs2.length);
 }while(randomIndex ==randomIndex2 );

do{
 randomIndex3 = new Random().nextInt(qs2.length);
 }while(randomIndex2 ==randomIndex3 );