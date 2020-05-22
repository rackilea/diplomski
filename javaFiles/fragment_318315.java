try {
    DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
    Date date = dateFormat.parse("Jul 20, 2018");
}
catch(ParseException pe ) {
    // handle the failure
}