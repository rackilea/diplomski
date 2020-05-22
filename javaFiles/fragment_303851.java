ResultSetMetaData rsmd = res.getMetaData();
int columnsNumber = rsmd.getColumnCount();

sStatus = cstmt.getString("sStatus");
sMessage = cstmt.getString("sMessage");

if (columnsNumber > 1) {

    while (res.next()) {

    JSONObject jObj = new JSONObject();
    jObj.put(APP_CONSTANT.SYMBOL, res.getString("SYMBOL"));
    jObj.put(APP_CONSTANT.DESCRIPTION, res.getString("DESCRIPTION"));
    jArray.put(jObj);

    }
}

DBConnection.closeResultSet(res);

hasResult = cstmt.getMoreResults();