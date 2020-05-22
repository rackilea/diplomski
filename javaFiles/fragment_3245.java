String[] locationProjection;
switch (datacontentprovider.sUriMatcher.match(uri)) {
        case datacontentprovider.LOCATION:

            locationProjection = new String[] {
                    datacontentprovider.DatabaseHelper.COLUMN_LATITUDE,
                    datacontentprovider.DatabaseHelper.COLUMN_LONGITUDE,
                    datacontentprovider.DatabaseHelper.COLUMN_TIME,
                    datacontentprovider.DatabaseHelper.COLUMN_ACCURACY,
                    datacontentprovider.DatabaseHelper.COLUMN_PROVIDER };
            break;
            //...
}