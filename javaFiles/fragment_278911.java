JFreeChart chart;
if(jComboBox6.getSelectedItem().equals("Scatter Plot"))
   {
   chart = ChartFactory.createScatterPlot("Scatter Plot","Year","Production", dataset);
   }
if(jComboBox6.getSelectedItem().equals("Line Chart"))
   {
   chart = ChartFactory.createScatterPlot("Line Chart","Year","Production", dataset);
   }
ChartPanel chartPanel = new ChartPanel(chart, false);