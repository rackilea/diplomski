public static void main(String[] args) throws ParseException {

    SimpleDateFormat sourceFormat = new SimpleDateFormat("MM/dd/yyyy");
    SimpleDateFormat destinationFormat = new SimpleDateFormat("yyyy-MM-dd");

    String sourceDateString = "02/16/2012";
    String destinationDateString;

    Date dat; // this object stores "perfect" date object

    // interpreting string with input format and converting it to date
    dat = sourceFormat.parse(sourceDateString);

    // expressing date object as string in destination format
    destinationDateString = destinationFormat.format(dat);

    System.out.format("Done from %s to %s\n", sourceDateString, destinationDateString));


}