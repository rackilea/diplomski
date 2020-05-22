public JFreeChart createBarChartFromCSV() {     


csv csvReader = new csv();
        List<String[]> csvData1 = null;
                List<String[]> csvData2 = null;
        int indexOfAverage1 = 0;
                int indexOfAverage2 = 0;

        csvData1 = csvReader.getDataFromCSV1(csv.CSVFILENAME1);
                csvData2 = csvReader.getDataFromCSV2(csv.CSVFILENAME2);

        for(String[] columnArray : csvData1)
            for(int i = 0; i< columnArray.length; i++)
                if(columnArray[i].equalsIgnoreCase("average")){


enter code here

        indexOfAverage1 = i;
                    break;
                }

        if(indexOfAverage1 == 0){
            System.err.println("Error retrieving data from CSV File1 !!");
            System.exit(0);
        }


         for(String[] columnArray : csvData2)
            for(int j = 0; j< columnArray.length; j++)
                if(columnArray[j].equalsIgnoreCase("average")){
                    indexOfAverage2 = j;
            break;
                }

        if(indexOfAverage2 == 0){
            System.err.println("Error retrieving data from CSV File2 !!");
            System.exit(0);
}                


                JFreeChart barChart = generateBarChart(csvData1,csvData2, indexOfAverage1,indexOfAverage2);

        return barChart;
    }


    private JFreeChart generateBarChart(List<String[]> csvData1,List<String[]> csvData2, int columnIndex1, int columnIndex2){

        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        final String YAXIS_NAME = csvData1.get(0)[columnIndex1]; //value returned is "average"
        final String XAXIS_NAME = csvData1.get(0)[0]; //value returned is "sampler_label"

        for(int i = 1; i < csvData1.size() - 1; i++){

            long averageValue1 = Long.parseLong(csvData1.get(i)[columnIndex1]);
            String columnKey1 = csvData1.get(i)[0];

            dataSet.setValue(averageValue1, YAXIS_NAME, columnKey1); // plot the graph
                        }


        for(int j = 1; j< csvData2.size() - 1; j++){

            long averageValue2 = Long.parseLong(csvData2.get(j)[columnIndex2]);
            String columnKey2 = csvData2.get(j)[0];

            dataSet.setValue(averageValue2, YAXIS_NAME, columnKey2); // plot the graph

        }

             System.out.println("created");

JFreeChart chart = ChartFactory.createBarChart("Comparison between the average of 2 values", XAXIS_NAME, YAXIS_NAME, dataSet, PlotOrientation.VERTICAL, true, true, false);      
        final CategoryPlot plot = chart.getCategoryPlot();
        chart.setBackgroundPaint(Color.white);       
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        BarRenderer renderer=new BarRenderer();

      System.out.print( "set the range axis to display integers only...");
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

          System.out.print( "disable bar outlines...");
        renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        renderer.setMaximumBarWidth(0.10);


          System.out.print( "set up gradient paints for series...");
    final GradientPaint gp0 = new GradientPaint(
            0.0f, 0.0f, Color.blue, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp1 = new GradientPaint(
            0.0f, 0.0f, Color.green, 
            0.0f, 0.0f, Color.lightGray
        );

        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);



                return chart;
    }