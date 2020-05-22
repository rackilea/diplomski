int number = Integer.parseInt(monthNumber);

if (number < 1 || number > 12) {
    again = true;
    throw new Exception();
}