// format string. This returns MMdd
    final SimpleDateFormat sdf = new SimpleDateFormat("MMdd");

    //redundant re-declaration of function parameter
    final int dayOfYear = quant;

    // make a date and set DAY_OF_YEAR to quant
    final Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);

    // get date and return it in the correct format
    final Date dat = calendar.getTime();
    return sdf.format(dat);