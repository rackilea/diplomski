int year = 2010 + choice / 12;
int month = 1 + choice % 12;

switch (month) {
    case 1: System.out.println("January " + year);
            break;
    case 2: System.out.println("February " + year);
            break;

    // so on
}