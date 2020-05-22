boolean found = false;
   for (int i = 0; i < materialsRow.size(); i++) {
       String name = materialsRow.get(i).getText();
       Thread.sleep(500);
       if (name.contains(item)) {
           clickAction .get(i).click();
           found = true;
           break;  // do not need to look anymore
        } 
   }

   if (!found) throw new Exception ("not found");