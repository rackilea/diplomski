super.layoutPlotChildren();
    XYChart.Series s =  (XYChart.Series) getData().get(0);
    XYChart.Series d = (XYChart.Series) getData().get(1);
    ObservableList<XYChart.Data<X,Y>> systole = s.getData();
    ObservableList<XYChart.Data<X,Y>> diastole = d.getData();

    for(int i = 0; i < systole.size()-1; i++)
    {       
            XYChart.Data SysPoint  = systole.get(i);
            XYChart.Data DiasPoint = diastole.get(i);
            double x = getXAxis().getDisplayPosition(SysPoint.getXValue().toString()); 
            double y = getYAxis().getDisplayPosition(DiasPoint.getYValue()); 
            double x2 = getXAxis().getDisplayPosition(systole.get((i+1)).getXValue().toString());
            double y2 = getYAxis().getDisplayPosition(diastole.get((i+1)).getYValue());
              Polygon polygon = new Polygon();
              LinearGradient linearGrad = new LinearGradient(
            0,   // start X 
            0,   // start Y
            0,   // end X
            1, // end Y
            true, // proportional
            CycleMethod.NO_CYCLE, // cycle colors
            // stops
            new Stop(0.1f, Color.rgb(255, 0, 0, .3)),
            new Stop(0.5f, Color.rgb(127, 0, 127, .3)),
            new Stop(1.0f, Color.rgb(0, 0, 255, .3)));

                polygon.getPoints().addAll(new Double[]{
                    x,y,
                    x, getYAxis().getDisplayPosition(SysPoint.getYValue()),   
                      x2,getYAxis().getDisplayPosition(systole.get((i+1)).getYValue()), 
                    x2,y2
                });
            getPlotChildren().add(polygon);
            polygon.toFront();
            polygon.setFill(linearGrad);
    }               


}