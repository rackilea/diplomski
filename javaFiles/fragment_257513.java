public void add() {
     synchronized(Testing.class){     
          i++;
          System.out.println(i);
     }
}