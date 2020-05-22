try {
    qq = Long.parseLong(q);
} catch(NumberFormatException nfe) {
    // show error message like "The string ... you entered is not a number."
    ...
}