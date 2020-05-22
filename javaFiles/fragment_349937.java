//this method compares to Lists of StockData, and returns a list containing all
//the StockData objects that had matches
public List<StockData> comparewithsecondarray(List<StockData> StockData1, List<StockData> StockData2) {
List<StockData> list = new ArrayList<StockData>();

for(StockData sd1: StockData1){
   for(StockData sd2: StockData2){
      if(sd1.equals(sd2)){
         //found a match!  add it to the list
         list.add(sd1);
         //break so we don't add the same object multiple times
         break;
      }
   }
}
return list;
}