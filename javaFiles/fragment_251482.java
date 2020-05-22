double result = 0;
int div = 1;
for (int i = 1; i <= 100; i++){
    result += 1.0 / div; /*the division needs to take place in floating point*/
    div *= i+1; 
}