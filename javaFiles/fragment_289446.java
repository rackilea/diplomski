private class ChartCustomizer implements DRIChartCustomizer, Serializable {  
   public void customize(JFreeChart chart, ReportParameters reportParameters) {  
      CategoryAxis domainAxis = chart.getCategoryPlot().getDomainAxis();  
      domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI/2));
   }  
}