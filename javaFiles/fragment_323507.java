int answer = -1; // that's the default answer.
int maxAmount = 0; // what if first keyboard + first usb are unaffordable? let's put it to 0

//This will compare the value of i+j throughout the loop and returns the max one 
for(int i: keyboards){
  for(int j: drives){
    if((i+j) > b) {
      // do nothing, it's unaffordable (and remove this block)
    }else if((i+j) == b){
       answer = i+j; 
       return answer;// it can't be more, stop the loop and return the solution
    } else if((i+j) > maxAmount){ // no need to put an else, then an if both conditions are related
        maxAmount = i+j;
        answer = maxAmount;
    } 
  }
}