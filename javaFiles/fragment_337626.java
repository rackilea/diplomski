public static final int QUARTER = 25;
public static final int DIME = 10;
public static final int NICKEL = 5;

    double userInput = 123.39D;
    double changeDouble = userInput - (int)userInput;  // get smaller-than-1-dollar change
    int changeInt = (int)(changeDouble * 100);  // move two digits from right to left of decimal dot
    System.out.println("quarters: " + changeInt / QUARTER);
    changeInt -= (changeInt / QUARTER) * QUARTER;
    System.out.println("dimes: " + changeInt / DIME);
    changeInt -= (changeInt / DIME) * DIME;
    System.out.println("nickels: " + changeInt / NICKEL);
    changeInt -= (changeInt / NICKEL) * NICKEL;
    System.out.println("pennies: " + changeInt);