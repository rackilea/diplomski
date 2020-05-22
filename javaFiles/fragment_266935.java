for(int i=0; i< listOfLiElements.Count, i++){
 if(listOfLiElements[i].FindElement(By.ClassName("userContent")).Text == "TITLE TO LISTEN")
     {
      correctElement = listOfLiElements[i].FindElement(By.TagName("a"));
      i =listOfLiElements.Count;
     }
 }