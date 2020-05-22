Set<String> flightKeys = arrivals.keySet();
      Interator<String> flIter = flightKeys.iterator();
      while(flIter.hasNext()){
        String flKey = flIter.next();
        Set<MyObject> flights = arrivals.get(flKey );
        //use your flights set object
      }