int size1 = array1.length;
int size2 = array2.length;
int[] newArray = new int[size1 > size2 ? size1 : size2];


for(int i = 0; i < newArray.length; i ++){
  int sum = 0;
  if(size1 >= i && size2 >= i){
    sum = (array1[i] == null ? 0 : array1[i]) + (array2[i] == null ? 0 : array2[i]);
  } else if(size1 >= i && size2 < i){
    sum = array1[i] == null ? 0 : array1[i];
  } else{
    sum = array2[i] == null ? 0 : array2[i];
  }
  newArray[i] = sum;
}