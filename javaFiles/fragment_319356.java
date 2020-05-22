start = 0;
end = animalList.length() -1;
while(start < end){
  if(animalList[start].animal == "sheep"){
    if(animalList[end].animal == "goat"){
        swap(start,end); // This a function that would swap the elements you could do this in the loop as well
        end--;
        start++;
    }else{
      end--;
    }
  }else{
    start++;
  }
}