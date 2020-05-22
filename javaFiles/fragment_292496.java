public List<List<Integer>> split(int[] input) {
      Arrays.sort(input);
      int maxDup = getMaxDuplicateNumber(input);
      List<List<Integer>> result = new ArrayList<>(maxDup);
      for(int i = 0; i < maxDup; i++) {
         result.add(new LinkedList<>());
      }
      int count = 0;
      result.get(0).add(input[0]);
      for(int i = 1; i < input.length; i++) {
         if(input[i] == input[i-1]) {
            count++;
         } else {
            count = 0;
         }
         result.get(count).add(input[i]);
      }
      return result;
   }

   private int getMaxDuplicateNumber(int[] input) {
      int maxDups = 1;
      int currentDupCount = 1;
      for(int i = 1; i < input.length; i++) {
         if(input[i] == input[i - 1]) {
            currentDupCount++;
         } else {
            currentDupCount = 1;
         }
         if(currentDupCount > maxDups) {
            maxDups = currentDupCount;
         }
      }
      return maxDups;
   }