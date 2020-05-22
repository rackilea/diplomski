boolean doTheLoop = true;
    int i = 0;
    while (doTheLoop){      
        i = i+200;
        Thread.sleep(200);
        if (i>30000){
            doTheLoop = false;
        }
        if (!selenium.isVisible("id=the ID Of element")){
            doTheLoop = false;
      }      
}