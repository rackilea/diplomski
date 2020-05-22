int i = 1;
      do {
      System.out.println("start"+i);
      while(i++ <= 2)System.out.println("inner while loop "+i);
      }
      while(i++ <= 4)System.out.println("outer while loop"+i);
      System.out.println("final ans"+i);