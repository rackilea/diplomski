newArray = new int[100]; //recall the number of ints is defined, ex. 100
int a = 0;
for (int i = 0; i < aL.length; i++) { 
    for (int value : aL[i]) {
        newArray[a] = value;
        a++;
    }
}