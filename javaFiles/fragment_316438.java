@Test
public void formatDate() {
    Date today = new Date();
    SimpleDateFormat fourDigitsYearOnlyFormat = new SimpleDateFormat("yyyy");
    FieldPosition yearPosition = new FieldPosition(DateFormat.YEAR_FIELD);

    DateFormat dateInstanceUK = DateFormat.getDateInstance(DateFormat.SHORT, 
            Locale.UK);
    StringBuffer sbUK = new StringBuffer();

    dateInstanceUK.format(today, sbUK, yearPosition);

    sbUK.replace(yearPosition.getBeginIndex(), yearPosition.getEndIndex(), 
            fourDigitsYearOnlyFormat.format(today));
    System.out.println(sbUK.toString());

    DateFormat dateInstanceUS = DateFormat.getDateInstance(DateFormat.SHORT,
            Locale.US);
    StringBuffer sbUS = new StringBuffer();
    dateInstanceUS.format(today, sbUS, yearPosition);
    sbUS.replace(yearPosition.getBeginIndex(), yearPosition.getEndIndex(), 
            fourDigitsYearOnlyFormat.format(today));
    System.out.println(sbUS.toString());
}