Connection connection = ...
FbDatabase db = connection.unwrap(FirebirdConnection.class).getFbDatabase();
byte[] info = db.getDatabaseInfo(new byte[] { ISCConstants.isc_info_page_size }, 20);
if (info[0] == ISCConstants.isc_info_page_size) {
    int valueLength = VaxEncoding.iscVaxInteger2(info, 1);
    int pageSize = VaxEncoding.iscVaxInteger(info, 3, valueLength);
    // ...
}