Map<String, Integer> counted = new HashMap<String, Integer>();

 for (String s : theOriginalArray) {
      Integer count = counted.get(s);
      if (count == null) {
           counted.put(s, 1);
      } else {
           counted.put(s, count + 1);
      }
 }