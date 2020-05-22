Iterator<Integer> itr = tablica.iterator();
  while(itr.hasNext()) {
     Integer x = itr.next();
     if(x == 3) {
         itr.remove();
     }
  }