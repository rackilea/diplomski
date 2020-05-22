int index = 0;
for(int index=0;index<z;index++) {
    a[index] = index;
}
index = 0;
while (index < z/2){
    a = swap(a, index, z-index-1);
    index++;
}