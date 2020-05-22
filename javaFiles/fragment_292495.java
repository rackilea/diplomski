public List<List<Integer>> split(int[] input) {
      Map<Integer, Integer> occurrences = new HashMap<>();
      int maxOcc = 0;
      for (int val : input) {
         int occ = 0;
         if (occurrences.containsKey(val)) {
            occ = occurrences.get(val);
         }
         if (occ + 1 > maxOcc) {
            maxOcc = occ + 1;
         }
         occurrences.put(val, occ + 1);
      }
      List<List<Integer>> result = new ArrayList<>(maxOcc);
      for (int i = 0; i < maxOcc; i++) {
         result.add(new LinkedList<>());
      }
      for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
         for (int i = 0; i < entry.getValue(); i++) {
            result.get(i).add(entry.getKey());
         }
      }
      return result;
   }