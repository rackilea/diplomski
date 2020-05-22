/**
 * Creates a PdfPCell with the name of the month
 * @param calendar a date
 * @param locale a locale
 * @return a PdfPCell with rowspan 7, containing the name of the month
 */
public PdfPCell getMonthCell(Calendar calendar, Locale locale) {
    PdfPCell cell = new PdfPCell();
    cell.setColspan(7);
    cell.setBackgroundColor(BaseColor.WHITE);
    cell.setUseDescender(true);
    Paragraph p = new Paragraph(String.format(locale, "%1$tB %1$tY", calendar), bold);
    p.setAlignment(Element.ALIGN_CENTER);
    cell.addElement(p);
    return cell;
}

/**
 * Creates a PdfPCell for a specific day
 * @param calendar a date
 * @param locale a locale
 * @return a PdfPCell
 */
public PdfPCell getDayCell(Calendar calendar, Locale locale) {
    PdfPCell cell = new PdfPCell();
    cell.setPadding(3);
    // set the background color, based on the type of day
    if (isSunday(calendar))
        cell.setBackgroundColor(BaseColor.GRAY);
    else if (isSpecialDay(calendar))
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
    else
        cell.setBackgroundColor(BaseColor.WHITE);
    // set the content in the language of the locale
    Chunk chunk = new Chunk(String.format(locale, "%1$ta", calendar), small);
    chunk.setTextRise(8);
    // a paragraph with the day
    Paragraph p = new Paragraph(chunk);
    // a separator
    p.add(new Chunk(new VerticalPositionMark()));
    // and the number of the day
    p.add(new Chunk(String.format(locale, "%1$te", calendar), normal));
    cell.addElement(p);
    return cell;
}

/**
 * Returns true for Sundays.
 * @param calendar a date
 * @return true for Sundays
 */
public boolean isSunday(Calendar calendar) {
    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
        return true;
    }
    return false;
}

/**
 * Returns true if the date was found in a list with special days (holidays).
 * @param calendar a date
 * @return true for holidays
 */
public boolean isSpecialDay(Calendar calendar) {
    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
        return true;
    if (specialDays.containsKey(String.format("%1$tm%1$td", calendar)))
        return true;
    return false;
}