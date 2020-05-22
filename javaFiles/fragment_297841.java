private RenderImage getChartImage(Chart chart) { 
     //etc.
 }
 private static class Chart {
      private GanttChartModel model;
      private String title = "";
      //etc, initializing each field with its default value.
      private static class Builder {
           private Chart chart;
           public Builder(GanttChartModel model) {
                chart = new Chart();
                chart.model = model;
           }
           public setTitle(String title) {
                if (title != null) {
                    chart.title = title;
                }
           }
      }
  }