if (checkError()) //calls specific check for the error on the custom error page
    {
      //Log URL
      string badURL = driver.Url();
      //Save somewhere in a list for output later...

      //navigate to previous page
      driver.navigate().Back();
    }