boolean isEmpty = true;
    while (resSet.next()) {
        isEmpty = false;
        Log.d(TAG, "selectAll", "ID: "+resSet.getString(ID_COL));
        Log.d(TAG, "selectAll", "Node: "+resSet.getString(NODE_ID_COL));
        Log.d(TAG, "selectAll", "Lat: "+resSet.getString(LAT_COL));
        Log.d(TAG, "selectAll", "Lng: "+resSet.getString(LNG_COL));
        Log.d(TAG, "selectAll", "xmlPath: "+resSet.getString(XML_PATH_COL));
    }