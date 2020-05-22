int sum = 0;
int max = Integer.MIN_VALUE;
int min = Integer.MAX_VALUE;

for (int i=0; i < 5; ++i) {
    num = scan.nextInt();
    if (num > max) max = num;
    if (num < min) min = num;
    sum += num;
}

double average = sum / 5.0d;