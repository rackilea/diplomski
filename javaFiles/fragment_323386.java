XAxis xAxis = barChart.getXAxis();
    YAxis yAxisL = barChart.getAxisLeft();
    YAxis yAxisR = barChart.getAxisRight();
    xAxis.setDrawGridLines(false);
    xAxis.setDrawAxisLine(false);
    xAxis.setDrawLabels(false);
    yAxisL.setDrawAxisLine(false);
    yAxisL.setDrawLabels(false);
    yAxisR.setDrawGridLines(false);
    yAxisR.setDrawAxisLine(false);
    yAxisR.setDrawLabels(false);
    //remove horizontal lines
    AxisBase axisBase = barChart.getAxisLeft();
    axisBase.setDrawGridLines(false);