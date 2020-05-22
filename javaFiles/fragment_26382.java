public TableBean mapTableBean(TableParameters tableParameters) {
    int iTotalRecords = database.getCount();
    int iTotalDisplayRecords = iTotalRecords;
    if (null != tableParameters.getsEcho()){
        String sEcho = tableParameters.getsEcho().toString(); 
    }
    List data = database.search(tableParameters.getiDisplayStart(), tableParameters.getiDisplayLength(),
            tableParameters.getSortedColumnName(),
            tableParameters.getSortedColumnDirection().equalsIgnoreCase("asc"));

    return new TableBean(iTotalRecords, iTotalDisplayRecords, sEcho, data);
}