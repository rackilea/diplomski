public List<ExtendedBarModel> ModelList() {
    xbarmod = new ArrayList();
    sers = new ArrayList();

    //chartType = "bar";
    orig = guestChartFacade.findAll();

    for (Enguestjoinchart j : orig) {
        if (j.getCharttype().equals("bar")) {
            setChartType("bar");
            showBar = true;
            idmid = j.getIdmid();
            selJoin = guestChartFacade.find(idmid);
            startDate = selJoin.getStartdate();
            sers.add(idmid);
        }
    }

    dsetList = setfacade.findTopsRange(sers);

    processModelList();
    return xbarmod;
}


public ExtendedBarModel processModelList() {
    for (int i = 0; i < dsetList.size(); i++) {

        idmid = dsetList.get(i).getIdmid();

        pointList = pointFacade.pointRangeIdmid(idmid, startDate);
        xtestmodel = new ExtendedBarModel("Barmodel " + dsetList.get(i).getIdmid());

        chartSer = new ChartSeries();
        for (Endatapoint p : pointList) {
            chartSer.set(p.getRecords().getSeriesname(), p.getActualnum());

        }
        xtestmodel.addSeries(chartSer);
        xbarmod.add(xtestmodel);
    }

    for (ExtendedBarModel b : xbarmod) {
        xtestmodel = b;
        return xtestmodel;
    }
    return null;
}