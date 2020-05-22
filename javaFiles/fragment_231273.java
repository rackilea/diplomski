List<Integer> maxList = new ArrayList(); 

for (int i = 0; i < nonDecrease.length - 1;) {
   int prev = nonDecrease[i];
   List<Integer> currentMaxList = new ArrayList();
   currentMaxList.add(prev);

   int j = i + 1;
   for (; j < nonDecrease.length; j++) {
      if (nonDecrease[j] >= prev) {
          prev = nonDecrease[j];
          currentMaxList.add(prev);
      } else {
          break;
      }
   }
   if (currentMaxList.size() > maxList.size()) {
      // Found new longer
      maxList = currentMaxList;
   }
   // The non-decreasing break at `j` so we continue the next search at j:
   i = j;
}