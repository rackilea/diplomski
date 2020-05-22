float total = 0;
int count = 0;
while (scanner.hasNextFloat()) {
    float num = scanner.nextFloat();
    total += num;
    count++;
}
float average = total / count;