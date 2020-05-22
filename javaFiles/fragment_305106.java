Font customFont = new Font("SansSerif", Font.BOLD, 25);
final JFreeChart chart = CustomChartFactory.createBarChart(
            "Latecny histogram",       // chart title
            "Type",                    // domain axis label
            "Value",                   // range axis label
            dataset,                   // data
            PlotOrientation.VERTICAL,  // orientation
            true,                      // include legend
            true,                      // tooltips
            false,                     // urls
            customFont                 //font
);