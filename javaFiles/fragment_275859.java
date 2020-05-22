Context context = this;
// URI table
Uri uri = IsansysPatientGatewayContentProvider.CONTENT_URI_RESPIRATION_RATES;
// URI columns to get from table class
String[] projection = { 
        TableLifetouchRespirationRate.COLUMN_ID, 
        TableLifetouchRespirationRate.COLUMN_LIFETOUCH_ID, 
        TableLifetouchRespirationRate.COLUMN_RESPIRATION_RATE,
        TableLifetouchRespirationRate.COLUMN_ACKNOWLEDGMENT_MESSAGE, 
        TableLifetouchRespirationRate.COLUMN_TIMESTAMP,
        TableLifetouchRespirationRate.COLUMN_SESSION_NUMBER
        };       
// In the column ACKNOWLEDGMENT_MESSAGE...
String selection = TableLifetouchRespirationRate.COLUMN_ACKNOWLEDGMENT_MESSAGE  + "=?"; 
// Select rows = "0" (it is possible to add augments on several columns)
String[] selectionArgs = {"0"};
String sortOrder = null;

cursorLoader = new CursorLoader(context, uri, projection, selection, selectionArgs, sortOrder);