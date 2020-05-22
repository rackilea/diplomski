int temp = 0, a;
Scanner obj = new Scanner(System.in);
System.out.print("Enter the number ");
int n = obj.nextInt();
int i = 1;
while (true) {
    int pow = (int) Math.pow(3, i);
    if (pow > n) {
        break;
    } else {
        temp = temp + n / pow;
    }

    i++;
}
System.out.println("Answer: " + temp);