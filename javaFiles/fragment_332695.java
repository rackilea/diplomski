//legend
    CTLegend ctLegend = ctChart.addNewLegend();
    ctLegend.addNewLegendPos().setVal(STLegendPos.L);
    ctLegend.addNewOverlay().setVal(false);
    CTManualLayout ctManualLayout = ctLegend.addNewLayout().addNewManualLayout();
    ctManualLayout.addNewXMode().setVal(STLayoutMode.EDGE);
    ctManualLayout.addNewYMode().setVal(STLayoutMode.EDGE);
    ctManualLayout.addNewX().setVal(0.00); //left edge of the chart
    ctManualLayout.addNewY().setVal(0.25); //25% of chart's height from top edge of the chart