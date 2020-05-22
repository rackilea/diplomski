do {
    System.out.println("Enter a sales for the month: ");
    getInt = keyboard.nextInt();

    if (getInt < 0) break;

    if (getInt > max) max = getInt;
    if (getInt < min) min = getInt;

    sum += getInt;
    count++;

} while (count < 48);

if (count == 0) {
    System.out.println("No sales ever!");
    return;
}

int year = 2010 + count / 12;
int month = 1 + count % 12;