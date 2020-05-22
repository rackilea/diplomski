...
            XDDFChartData data = chart.createData(ChartTypes.SCATTER, bottomAxis, leftAxis);

            data.addSeries(xs, ys1);
            data.addSeries(xs, ys2);
            chart.plot(data);

            //setting the axis Ids to the ScatterChart
            chart.getCTChart().getPlotArea().getScatterChartArray(0).addNewAxId().setVal(bottomAxis.getId());
            chart.getCTChart().getPlotArea().getScatterChartArray(0).addNewAxId().setVal(leftAxis.getId());


            // Write the output to a file
            try (FileOutputStream fileOut = new FileOutputStream("ooxml-scatter-chart.xlsx")) {
                wb.write(fileOut);
            }

...