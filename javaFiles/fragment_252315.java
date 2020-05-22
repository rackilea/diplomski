while (scaner.hasNextInt()) {
    int val = scaner.nextInt();
    if (val < 0 || val >= 10) {
        break;
    }
    ...
}