pos = array.length - 1;
bitmask = 156;                              // as an example, take bitmask = 156
while(bitmask > 0){
    if(bitmask%2 == 1)                      // odd == remainder 1, it is in the set
         System.out.print(array[pos]+",");
    bitmask /= 2;                           // divide by 2
    pos--;
}