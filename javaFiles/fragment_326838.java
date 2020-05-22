public void xyzToFront()
  {
      int insertAt = 0;
      but otherwise preserves the order
      for (int i = 0; i < list.size(); i++) { 
          if (temp.startsWith("x") || temp.startsWith("y") || temp.startsWith("z")) {    
              String temp = list.get(i);
              list.remove(i);
              list.add(insertAt++, temp);
          }
      }
 }