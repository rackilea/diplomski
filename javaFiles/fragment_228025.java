public class FormatLog {

    private String searchRequiredString, searchStartString, searchEndString;
    private String regex, line;
    private Integer lengthStartStr, lengthEndStr;

    private File inputFile;

    private Integer rowNum, colNum;
    private HSSFCell cell;

    private String[] ary;

    private Logger log;

    // Initializing data in constructor
    public FormatLog() {
        // initializing the logger for log4j
        log = Logger.getLogger(FormatLog.class);

        @SuppressWarnings("resource")
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "spring.xml");

        // Initializing search String related parameters
        searchRequiredString = (String) ctx.getBean("searchRequiredString");
        searchStartString = (String) ctx.getBean("searchStartString");
        searchEndString = (String) ctx.getBean("searchEndString");
        regex = (String) ctx.getBean("regex");

        // Initializing the Log Input File
        inputFile = (File) ctx.getBean("inputFile");

        // Computing some start parameters
        lengthStartStr = searchStartString.length();
        lengthEndStr = searchEndString.length();

        // Row Number initialized to -1
        rowNum = -1;
    }

    /*
     * Input: None Output: Integer rowNum - number of rows processed.
     */
    @SuppressWarnings({ "resource", "deprecation" })
    public Integer stringManipulation() {

        // setting header text
        String[] headerText = { "Date", "Facility Name", "Work Center",
                "ID Nbr", "Preference", "Format", "Printer Name", "Qty" };
        DateFunctions df = new DateFunctions();
        try {
            FileOutputStream fileOut = new FileOutputStream(
                    "c:\\logAnalyzer\\FormattedLogsELC.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("ELC Log Worksheet - "
                    + df.getStartDate().toString());

            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            while ((line = br.readLine()) != null) {
                // Create the StringBuilder
                StringBuilder builder = new StringBuilder(line);

                Integer indexRequired = builder.indexOf(searchRequiredString);
                if (indexRequired > 0) {

                    String date = builder.subSequence(1, 17).toString();
                    log.debug(date);
                    Date logDate = new Date(date);
                    if (df.isTimeDiffAcceptable(logDate)) {

                        log.debug(builder.toString());
                        Integer indexStart = builder.indexOf(searchStartString);
                        Integer indexEnd = builder.indexOf(searchEndString);
                        String s = builder.subSequence(
                                indexStart + lengthStartStr,
                                indexEnd - lengthEndStr + 1).toString();
                        // adding date to the string s
                        s = date + "," + s;
                        log.debug(s);
                        ary = s.split(regex);
                        if (ary.length != headerText.length) {
                            log.warn("Review row number : " + rowNum
                                    + ". Unexpected data was found");
                        }

                        // incrementing RowNumber for workbook calculation.
                        rowNum++;
                        if (rowNum == 0) {
                            log.info("Setting Header Text");
                            ary = headerText;
                        }
                        log.info("Row Number: " + rowNum
                                + " extracted for time : " + date);
                        // Create a new wb row.
                        HSSFRow row = worksheet.createRow(rowNum);
                        for (colNum = 0; colNum < ary.length; colNum++) {
                            ary[colNum] = ary[colNum].trim();
                            log.debug(ary[colNum]);
                            cell = row.createCell(colNum);
                            cell.setCellValue(ary[colNum]);
                        }// end for
                    }// end if timeDiff
                }// end if indexRequired
            } // while

            // write to workbook and close it
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();

        } catch (FileNotFoundException e) {
            log.error(e);
        } catch (IOException e) {
            log.error(e);
        }

        if (rowNum < 0) {
            log.warn("No rows were written to the excel file.");
            log.warn("Application Logs provided may be out of the Wily alert window if no exception was thrown.");

        } else {
            log.info("Success");
        }

        // Returns the rows processed
        return rowNum;
    }
}