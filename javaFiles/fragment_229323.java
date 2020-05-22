public List<LineChartModel> makelinelistModel() {
    linemodelList = new ArrayList();
    linesers = new ArrayList();

    orig = guestChartFacade.findAll();

    for (Enguestjoinchart w : orig) {
        if (w.getCharttype().equals("line")) {
            idmidLine = w.getIdmid();
            selJoinLine = guestChartFacade.find(idmidLine);

            startDateLine = guestChartFacade.findStart(idmidLine);

            endDateLine = guestChartFacade.findEnd(idmidLine);
            linesers.add(idmidLine);
            showLine = true;
        }
    }

    if (linesers.size()==0) {
        dsetlineList = null;
        linemodelList = null;

    } 
    else {
       dsetlineList = setfacade.findTopsRange(linesers);
        processLineModelList();
    }
    return linemodelList;

}

public LineChartModel processLineModelList() {
    for (int i = 0; i < dsetlineList.size(); i++) {

        idmidLine = dsetlineList.get(i).getIdmid();
        pointListLine = pointFacade.pointLineRange(idmidLine, startDateLine, endDateLine);
        linemodel = new LineChartModel();

        chartSerLine = new ChartSeries();
        Map<Object, Number> datMap = new HashMap();
        DateAxis axis = new DateAxis();

        for (Endatapoint p : pointListLine) {
            chartSerLine.set(p.getPointdate().toString(), p.getActualnum());
            linemodel.addSeries(chartSerLine);

        }

        linemodelList.add(linemodel);
        linemodel.getAxes().put(AxisType.X, axis);
    }

    for (LineChartModel m : linemodelList) {
        linemodel = m;
        return linemodel;
    }
    return linemodel;
}

.... Other chart models