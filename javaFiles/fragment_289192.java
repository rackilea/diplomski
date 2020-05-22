public static void main( String [] args ) {
    try {

        InputStream input = POIExample.class.getResourceAsStream( "qa.xls" );
        POIFSFileSystem fs = new POIFSFileSystem( input );
        HSSFWorkbook wb = new HSSFWorkbook(fs);


        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
            HSSFSheet sheet = wb.getSheetAt(i);

            // Do your stuff        
        }

    } catch ( IOException ex ) {
        ex.printStackTrace();
    }
}