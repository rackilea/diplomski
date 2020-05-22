public void changeColorsOfChart(StackedBarChart<String, Number> chart)
    {
        ArrayList<Color> listColors = new ArrayList<Color>();
        HashMap<String, String> colors = new HashMap<String, String>();
        for (XYChart.Series<String, Number> series : chart.getData()) 
        {
            String rgb = randomColorRgbFormat();
            while (listColors.contains(rgb))
            {
                rgb = randomColorRgbFormat();
            }
            for (XYChart.Data<String, Number> data : series.getData())
            {
                data.getNode().setStyle("-fx-bar-fill: rgb(" + rgb + ");");
            }
            colors.put(series.getName(), rgb);
        }
        for (Node n : chart.getChildrenUnmodifiable())
        {
            if (n instanceof Legend)
            {
                for (LegendItem items : ((Legend)n).getItems())
                {
                    String rgb = colors.get(items.getText());
                    items.getSymbol().setStyle("-fx-bar-fill: rgb(" + rgb + ");");
                }
            }
        }
    }