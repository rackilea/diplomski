for (int i = 0; i < buckets.size(); i++) {
     for (int j = 0; j < buckets.get(i).size(); j++) {

        // ***** here *****
        sorted.add(buckets.get(j).poll());

     }
  }