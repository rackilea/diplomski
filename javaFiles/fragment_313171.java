for (int i = j+1; i < instrumentList.size(); i++) {
      b = instrumentList.get(i).getName();
      System.out.println("temp1 " + a + " temp2 " + b);
      if(a.equals(b)){
         found = true;
      }
   }