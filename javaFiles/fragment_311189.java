public class ChartHHmmCustomizer implements JRChartCustomizer {

    @Override
    public void customize(JFreeChart jfchart, JRChart jrchart) {

        //Get the category plot
        CategoryPlot plot = (CategoryPlot) jfchart.getPlot();

        //Crete a date axis
        DateAxis yAxis = new DateAxis();
        //Override the date format
        yAxis.setDateFormatOverride(new SimpleDateFormat("HH:mm"));
        //Customize tick unit
        yAxis.setTickUnit(new DateTickUnit(DateTickUnitType.HOUR, 1));
        //Set it to the range axis
        plot.setRangeAxis(yAxis);

        //adding a customize item label renderer to view the valus on the barchart
        CategoryItemRenderer renderer = ((CategoryPlot) jfchart.getPlot()).getRenderer();
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}",new SimpleDateFormat("HH:mm")));
        renderer.setBaseItemLabelsVisible(true);
        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER);
        renderer.setBasePositiveItemLabelPosition(position);
    }
}