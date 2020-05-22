public static void main(String[] args) throws ParseException {

    List<Date> dateList = new ArrayList<Date>();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    dateList.add(sdf.parse("5/1/2015"));
    dateList.add(sdf.parse("20/2/2015"));
    dateList.add(sdf.parse("15/3/2015"));
    dateList.add(sdf.parse("11/4/2015"));

    System.out.println("Testing with 1/3/2015.");

    dateSorting(dateList, sdf.parse("1/3/2015"));

    System.out.println("Testing with 1/1/2015.");

    dateSorting(dateList, sdf.parse("1/1/2015"));

    System.out.println("Testing with 12/4/2015.");

    dateSorting(dateList, sdf.parse("12/4/2015"));

}