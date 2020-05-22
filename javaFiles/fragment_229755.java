int o1=0;
int o2=0;
for (int p:set) {
    System.arraycopy(oldArray, o1, newArr, o2, p-o1);
    o1+=p+1;
    o2+=p;
}
System.arraycopy(oldArray, o1, newArray, o2, oldArray.length-o1);