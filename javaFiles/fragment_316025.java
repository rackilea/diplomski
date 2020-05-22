function filter(array, target): Boolean{ //assumes array is sorted in descending order
  if(sum(array) < target) return false;
  for(i = array.length-1; i>=0; --i){
    if(! filter(array.createCopyRemovingElementAt(i), target)) break;
  }
  if(i==array.length-1) print(array); // solution is "optimal": could not remove a single number
  return true;
}