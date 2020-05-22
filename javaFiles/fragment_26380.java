private static String iDisplayLength = "iDisplayLength";
private static String iDisplayStart = "iDisplayStart";
private static String iColumns = "iColumns";
private static String sSearch = "sSearch";
private static String bRegex = "bRegex";
private static String iSortingCols = "iSortingCols";
private static String sEcho = "sEcho";
private static String iSortCol_0 = "iSortCol_0";
private static String sSortDir_0 = "sSortDir_0";

public TableParameters getTableParameters(Map<String, String> allRequestParams) {

    TableParameters finalBean = new TableParameters();

    if (null != allRequestParams.get(bRegex)) {
        finalBean.setbRegex(new Boolean(allRequestParams.get(bRegex)));
    }
    if (null != allRequestParams.get(iColumns)) {
        finalBean.setiColumns(new Integer(allRequestParams.get(iColumns)));
    }
    if (null != allRequestParams.get(iDisplayLength)) {
        finalBean.setiDisplayLength(new Integer(allRequestParams.get(iDisplayLength)));
    }
    if (null != allRequestParams.get(iDisplayStart)) {
        finalBean.setiDisplayStart(new Integer(allRequestParams.get(iDisplayStart)));
    }
    if (null != allRequestParams.get(iSortingCols)) {
        finalBean.setiSortingCols(new Integer(allRequestParams.get(iSortingCols)));
    }
    if (null != allRequestParams.get(sEcho)) {
        try {
            finalBean.setsEcho(new Integer(allRequestParams.get(sEcho)));
        } catch (Exception e) {
            // ignore
        }
    }
    if (null != allRequestParams.get(sSearch)) {
        finalBean.setsSearch(allRequestParams.get(sSearch));
    }

    int numberOfColumnsSortedOn = 0;
    if (allRequestParams.containsKey(iSortingCols) && null != allRequestParams.get(iSortingCols)) {
        numberOfColumnsSortedOn = new Integer(allRequestParams.get("iSortingCols")).intValue();
    }

    if (numberOfColumnsSortedOn > 0) {
        if (null != allRequestParams.get(iSortCol_0)) {
            finalBean.setSortedColumnNumber(new Integer(allRequestParams.get(iSortCol_0)));
        }
        if (null != allRequestParams.get(sSortDir_0)) {
            finalBean.setSortedColumnDirection(allRequestParams.get(sSortDir_0));
        }
        String keyForName = "mDataProp_" + finalBean.getSortedColumnNumber();
        if (null != allRequestParams.get(keyForName)) {
            finalBean.setSortedColumnName(allRequestParams.get(keyForName).toUpperCase());
        }
    }
    return finalBean;
}