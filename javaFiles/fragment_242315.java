private void passStingR(StringBuilder retVal) throws BadLocationException, Exception {
    int getinitialscrollpos;
    getinitialscrollpos = getinitialscrollPosition(scrollMEL);
    try {
        CategoryPlot plot = (CategoryPlot) chartPanel.getChart().getPlot();//get plot of graph
        //System.out.print("Plot Type" + plot);
        ValueAxis rangeAxis = plot.getRangeAxis();//get range of axis of graph
        System.out.print("Range " + rangeAxis);//get range lower and upper as an array
        map.put(1, rangeAxis);
    } catch (Exception e) {
        System.out.print("Error has occured");
    } finally {
    ////refresh data////
        Document docR = null;
        docR = loadXMLFromString(retVal.toString());//pull in the XML data into a new doc
        populate1R(docR);
        tableMEL.getTableHeader().setReorderingAllowed(false);//prevent user from changing column order now at refresh level
        SimpleDateFormat time_formatterR = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current_time_strR = time_formatterR.format(System.currentTimeMillis());
        updatetFieldDG.setText(current_time_strR);
        middlePanel.add(scrollMEL);
        scrollMEL.getVerticalScrollBar().setValue(getinitialscrollpos);
        System.out.println("End" + getinitialscrollpos);
        getTableData(tableMEL);
        head(tableMEL);
        createGraphGUI();
        if (map.get(1) != null) {
            System.out.print("get map" + map.get(1));
            CategoryPlot plot = (CategoryPlot) chartPanel.getChart().getPlot();
            plot.setRangeAxis(map.get(1));//get range of axis of graph
        }
    }
}