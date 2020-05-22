...
if(pole[j-1] > pole[j]) {
    tm = pole[j-1];
    //assign the value here
    pole[j-1] = pole[j];
    pole[j] = tm;
}
...