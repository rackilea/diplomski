long startTime=   System.currentTimeMillis();
do {

......

     long currTime=  System.currentTimeMillis();
     long elapsedtime = currTime - startTime;
     if(elapsedtime > 20000)
      {
      break;
      }
}