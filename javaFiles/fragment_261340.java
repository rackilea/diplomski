public LocalDate convertDateObject(java.util.Date suspectDate) {

    try {
        // Don't do this if there is the smallest chance 
        // it could be a java.sql.Date!
        return suspectDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    } catch (UnsupportedOperationException e) {
        // BOOM!!
    }

    // do this first:
    java.util.Date safeDate = new Date(suspectDate.getTime());

    return safeDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

}