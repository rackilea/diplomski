val aValue = aValueProcess();
    int attempts = 0;

    //Wait 10 minutes and try again if value is null and we have not tried 
    //3 times (30 minutes of trying)
    while(aValue == null && attempts < 3)
    {
      thread.sleep(600000); //10 minutes in milliseconds
      attempts += 1;
      aValue = aValueProcess();
    }