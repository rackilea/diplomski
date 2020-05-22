int      n           = arr.length;
double   min         = Double.MAX_VALUE;
int      minLocation = 0;

for(int i = 0; i < n; i++) {
    if(arr[i] < min) {
        min         = arr[i];
        minLocation = i;
    }
}