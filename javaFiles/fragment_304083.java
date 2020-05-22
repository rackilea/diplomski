private static org.slf4j.Logger logger = LoggerFactory.getLogger( "Data" );

public static Object[][] getExcelData( File excelFile, String sheetName ) 
{   
    ExcelConfiguration conf = new ExcelConfiguration( 1, true, false );
    DataContext dataContext = DataContextFactory.createExcelDataContext( excelFile, conf );
    DataSet dataSet = dataContext.query()
            .from( sheetName )
            .selectAll()
            .where("run").eq("Y")
            .execute();
    List<Row> rows = dataSet.toRows();
    Object[][] myArray = get2ArgArrayFromRows( rows );
    return myArray;
}

/**
 * Gets a 2D Object array from a List of Row objects that is only 2 args wide.
 * @param rows
 * @return
 */
public static Object[][] get2ArgArrayFromRows( List<Row> rows ) {
    Object[][] myArray = new Object[rows.size()][2];
    int i = 0;
    SelectItem[] cols = rows.get(0).getSelectItems();
    for ( Row r : rows ) {
        Object[] data = r.getValues();
        for ( int j = 0; j < cols.length; j++ ) {
            if ( data[j] == null ) data[j] = ""; // force empty string where there are NULL values
        }
        myArray[i][0] = cols;
        myArray[i][2] = data;
        i++;
    }
    logger.info( "Row count: " + rows.size() );
    logger.info( "Column names: " + Arrays.toString( cols ) );
    return myArray;
}