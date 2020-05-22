try {
    long qq = 0;
    if (q != null && !q.isEmpty()) {
       qq = Long.parseLong(q);
    }

    ...

} catch(NumberFormatException nfe) {
    // show error message like "The string ... you entered is not a number."
    ...
}