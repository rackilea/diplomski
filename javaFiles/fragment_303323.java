// The solution itself 
  HashMap<Integer, Integer> repetitions = new HashMap<Integer, Integer>();

  for (int i = 0; i < crr_array.length; ++i) {
      int item = crr_array[i];

      if (repetitions.containsKey(item))
          repetitions.put(item, repetitions.get(item) + 1);
      else
          repetitions.put(item, 1);
  }

  // Now let's print the repetitions out
  StringBuilder sb = new StringBuilder();

  int overAllCount = 0;

  for (Map.Entry<Integer, Integer> e : repetitions.entrySet()) {
      if (e.getValue() > 1) {
          overAllCount += 1;

          sb.append("\n");
          sb.append(e.getKey());
          sb.append(": ");
          sb.append(e.getValue());
          sb.append(" times");
      }
  }

  if (overAllCount > 0) {
      sb.insert(0, " repeated numbers:");
      sb.insert(0, overAllCount);
      sb.insert(0, "There are ");
  }

  System.out.print(sb.toString());