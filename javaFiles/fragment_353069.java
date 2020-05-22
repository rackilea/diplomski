while (...) {
    // this can throw NumberFormatException
    Integer.parseInt(...)

    try {
        // the code in here cannot
    } catch (NumberFormatException e) {
        // therefore this is never reached
    }
}