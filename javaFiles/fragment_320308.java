public void getPieChart() {

        DefaultPieDataset pieDataset = new DefaultPieDataset();
    pieDataset.setValue("JavaWorld", new Integer(75));
    pieDataset.setValue("Other", new Integer(25));

        JFreeChart chart = ChartFactory.createPieChart("Discounts Used by Category ", data, true, true, false);
        //chart.setBackgroundPaint(new Color(222, 222, 255));
            final PiePlot plot = (PiePlot) chart.getPlot();
            plot.setBackgroundPaint(Color.white);
            plot.setCircular(true);

        try {

            final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
            final File file1 = new File(getServletContext().getRealPath(".") + "/images/charts/piechart.png");

            ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);
        } catch (Exception e) {
            System.out.println(e);

        }
    }