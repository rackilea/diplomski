public String toString() {
    switch (getCellTypeEnum()) {
        case BLANK:
            return "";
        case BOOLEAN:
            return getBooleanCellValue()?"TRUE":"FALSE";
        case ERROR:
            return ErrorEval.getText((( BoolErrRecord ) _record).getErrorValue());
        case FORMULA:
            return getCellFormula();
        case NUMERIC:
            //TODO apply the dataformat for this cell
            if (DateUtil.isCellDateFormatted(this)) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", LocaleUtil.getUserLocale());
                sdf.setTimeZone(LocaleUtil.getUserTimeZone());
                return sdf.format(getDateCellValue());
            }
            return  String.valueOf(getNumericCellValue());
        case STRING:
            return getStringCellValue();
        default:
            return "Unknown Cell Type: " + getCellType();
    }
}