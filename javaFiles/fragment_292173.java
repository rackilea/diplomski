String ItemName="android.widget.ImageButton";
    String Value="0";
    String str="//*[@class='"+ItemName+"' and @index='"+Value+"']"; //use this str in code

   //or you can directly use like below

   List imageList =driver.findElementsByXPath("//*[@class='"+ItemName+"' and @index='"+Value+"']");