Scanner in = new Scanner(System.in);
System.out.print("Voer een getal in: ");

if (in.hasNextInt()) {
    int number = in.nextInt();
    in.close();
    if (number < 0) {
    number = number * -1;

    if (number >= 10 && number < 100) {
        System.out.println("Het getal -" + number + " heeft 2 digits.");
    }

    else if (number >= 100 && number < 1000) {
        System.out.println("Het getal -" + number + " heeft 3 digits.");
    } else if (number >= 1000 && number < 10000) {
        System.out.println("Het getal -" + number + " heeft 4 digits.");
    } else if (number >= 10000 && number < 100000) {
        System.out.println("Het getal -" + number + " heeft 5 digits.");
    } else if (number >= 100000 && number < 1000000) {
        System.out.println("Het getal -" + number + " heeft 6 digits.");
    } else if (number >= 1000000 && number < 10000000) {
        System.out.println("Het getal -" + number + " heeft 7 digits.");
    } else if (number >= 10000000 && number < 100000000) {
        System.out.println("Het getal -" + number + " heeft 8 digits.");

    }

    } else {
    if (number >= 10 && number < 100) {
        System.out.println("Het getal " + number + " heeft 2 digits.");
    }

    else if (number >= 100 && number < 1000) {
        System.out.println("Het getal " + number + " heeft 3 digits.");
    } else if (number >= 1000 && number < 10000) {
        System.out.println("Het getal " + number + " heeft 4 digits.");
    } else if (number >= 10000 && number < 100000) {
        System.out.println("Het getal " + number + " heeft 5 digits.");
    } else if (number >= 100000 && number < 1000000) {
        System.out.println("Het getal " + number + " heeft 6 digits.");
    } else if (number >= 1000000 && number < 10000000) {
        System.out.println("Het getal " + number + " heeft 7 digits.");
    } else if (number >= 10000000 && number < 100000000) {
        System.out.println("Het getal " + number + " heeft 8 digits.");
    }

    }
} else {
     System.out.println(" Onjuiste invoer. Voer een getal in.");
}