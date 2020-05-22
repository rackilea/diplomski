public int remove(int index){
  //check for out-of-bounds
  if(index < 0 || index >= size) //assumes size is set to the size of the array
  {
    return -1; }
  else
    {
     for(int i = index; i < size-1; i++){
         data[i] = data[i+1]; }
         data[size-1] = 0;  //assuming the array contains numbers, if not replace '0' with null
    }
}