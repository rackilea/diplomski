...
StringBuilder powerLine = new StringBuilder();
while (i <= input) {

    powerLine.append(power + " + ");
    //System.out.print(power + " + ");

    sum = power + power;
    power = power * 2;

    i++;

    if (power > input) {
        System.out.print(powerLine.substring(0, powerLine.length() - 3));
        System.out.print(" = " + sum);
        System.exit(0);
    }
}