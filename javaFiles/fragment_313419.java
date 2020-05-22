int sum = 0;
int i = 2;
while (i<max) {
    sum+=i;
    if (sum > max) {
        break;
    }
    i+=2;
}
System.out.print("Value=" + sum);