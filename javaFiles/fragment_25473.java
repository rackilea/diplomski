int month = 0;
if (in.hasNextInt()) {
    month = in.nextInt();

    if (!(month > 0 && month <= 12)) {
        month = 0;
        System.out.println("ERROR");
    }
} else {
    // Handle graceful exit
}

...
if (0 < month && month <= 3) { ... }