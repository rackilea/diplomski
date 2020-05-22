String num = s.next();
int sum = 0;
for (int i = 1; i <= num.length(); ++i) {
    sum += (i * num.charAt(i - 1) - '0');
}

int d10 = (sum % 11);
if (d10 == 10) {
    System.out.println("The ISBN-10 number is " + num + "X");
} else {
    System.out.println("The ISBN-10 number is " + num + d10);
}