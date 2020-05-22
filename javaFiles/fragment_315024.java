Set<Data> soruceData;
Set<Data> targetData;
HashMap<Data,Integer> comparisonMap;
for(Data data:targetData){
 comparisonMap.put(data,0);
}
for(Data data:soruceData){
if(targetData.contains(data))
 comparisonMap.put(data,1);
else
 comparisonMap.put(data,0);
}