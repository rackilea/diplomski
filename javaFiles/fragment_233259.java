double num = 0.00000045;

int zeros = 0;
while (num < 1) {
    num *= 10;
    zeros++;
}
zeros -= 1;

System.out.println(zeros);