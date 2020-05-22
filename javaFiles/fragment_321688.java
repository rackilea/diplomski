int temp = n;
while (length == 5 && temp != 0) {
    reverse = reverse * 10;
    reverse = reverse + temp % 10;
    temp = temp / 10;
}