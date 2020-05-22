public void getTotalPower()
    {
       int totalPower = 0;
       for (BigGun oneGun : gun)
       {
           totalPower += oneGun.getNumberPower();
       }
       System.out.println(totalPower);
    }