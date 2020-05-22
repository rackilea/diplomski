int MAGIC = 50; //change it on each run of your program! You have to find the best value
int counter=1; // points[0] taken as included in accumulating solid segment
int startIndex=0,endIndex;
ArrayList<Integer> compressedDatesArray = new ArrayList<Integer>();
for(int i=1;i<datesArray.length;i++){
  if(deltaBetweenDates(datesArray[i]-datesArray[i-1])==1){
     counter++;
     endIndex=i;
     if(counter==MAGIC){
       counter=0;
       compressedDatesArray.add(datesArray[{endIndex-startIndex)/2]);
       startIndex=endIndex+1;
     }
  }

}