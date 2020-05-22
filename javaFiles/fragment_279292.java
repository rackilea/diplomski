Set<String> arrivalKeys = departures.keySet();
      Interator<String> arrIter = arrivalKeys.iterator();
      while(arrIter.hasNext()){
        String arrKey = arrIter.next();
        Map<String, Set<MyObject>> arrivals = departures.get(arrKey );
        //use your arrivals map object
      }