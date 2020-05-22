int j = -1;
int k = -1;
for(int i=0;i<towns.length;i++){//define variable j
   if (x.equals(towns[i])){
      j=i;
   }
}
for(int i=0;i<towns.length;i++){//define variable k
   if (y.equals(towns[i])){
      k=i;
   }
}
if (j == -1 || k == -1)
    return -1;