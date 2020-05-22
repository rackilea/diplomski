public void header(List<DynaBean> headerColumns) throws WriteException {
    for (DynaBean column : headerColumns) {
        int col = (Integer)column.get("columnNumber");
        int width = (Integer)column.get("columnWidth");

    //etcetera