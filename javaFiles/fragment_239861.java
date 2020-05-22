String mySeed = "";
      for(int i=0; i<81; i++)
      {
         int randomNum = (int)(Math.random()*27) + 65;
         if(randomNum==91)
            mySeed+="9";
         else
            mySeed+=(char)randomNum;
      }
      System.out.println(mySeed);