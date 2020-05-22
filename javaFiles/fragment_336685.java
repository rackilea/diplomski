int i;
float sum = 0;
for (i = 0; i < a.length * b.length; i++) {
    sum += a[i / b.length][i % b.length] * b[i % b.length];
}
System.out.println(sum);