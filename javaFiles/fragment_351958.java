List<Integer> resultSIList = Arrays.asList(1,2,3,4,5,6,7,8);
int totalSIs = resultSIList.size();
int maxItemsInOnePage = 2;
int offset = 1;

for (int i = offset, l = Math.min(i + maxItemsInOnePage, totalSIs); i < l; i++){
  resultSIList.get(i);
}