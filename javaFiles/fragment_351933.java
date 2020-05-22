// when increasing the i'th count
coll[i] += 1;
--hashTable[coll[i] - 1];
++hashTable[coll[i]];
// check whether also to update the max:
if(coll[i] > max){
  max = coll[i];
}
// check whether to update the min:
if(min == coll[i] - 1 && hashTable[coll[i] - 1] == 0){
  min = coll[i];
}