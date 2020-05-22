int inputs = 0;
try {
    inputs = Integer.parseInt(scan.nextLine());
} catch (NumberFormatException e) {
    // handle exception gracefully, maybe by showing a message to the user.
}