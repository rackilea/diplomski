int x =  0;
int i= 0;
int j = 0;
while(i != list1.length && j != list2.length){
  int v = list1[i].compareTo(list2[j]);
  if (v == 0){
    x++;i++;j++;
  }else if (v < 0){
    i++;
  } else {
    j++;
  }
}
return x;