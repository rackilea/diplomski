long iTime = System.currentTimeMillis();


if(System.currentTimeMillis - iTime >= (2*1000)) { //2 seconds to milliseconds
      increaseIron();
      iTime = System.currentTimeMillis();
}