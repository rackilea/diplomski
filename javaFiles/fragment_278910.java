if(jComboBox6.getSelectedItem().equals("Scatter Plot"))
   {
   JFreeChart chart = ChartFactory.createScatterPlot("Scatter Plot","Year","Production", dataset);
   }
if(jComboBox6.getSelectedItem().equals("Line Chart"))
   {
   JFreeChart chart = ChartFactory.createScatterPlot("Line Chart","Year","Production", dataset);
   }
ChartPanel chartPanel = new ChartPanel(chart, false);