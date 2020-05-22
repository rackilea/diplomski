int sumEven = 0;
int productoImpares = 1;
for(int i=0; i<=20; i++) {
    if (i % 2 == 0) {
        sumEven += i;
    } else {
        productoImpares *= i;
    }
}