public class GantDemo {
    public static void main(String[] args) throws ParseException {

        TaskSeriesCollection collection = new TaskSeriesCollection();
        List<SubTask> list = new ArrayList<SubTask>();
        list.add(new SubTask("T3.1", "2014-04-29", "2014-06-05"));
        list.add(new SubTask("T3.2", "2014-06-05", "2014-06-15"));
        list.add(new SubTask("T3.3", "2014-06-09", "2014-06-19"));
        TaskSeries schedule1 = new TaskSeries("Scheduled Tasks");
        for (SubTask task : list) {
            Date dateS = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(task.startDate);
            Date dateE = new SimpleDateFormat("yyyy-MM-dd").parse(task.endDate);

            schedule1.add(new Task(task.taskId, new SimpleTimePeriod(dateS,
                    dateE)));

        }
        collection.add(schedule1);
        System.out.println(collection.toString());

        IntervalCategoryDataset dataset = collection;
        JFreeChart chart = ChartFactory.createGanttChart("Gantt Chart Example", 
                "SubTask", // X-axis label
                "Date", // Y-axis label
                dataset, // dataset
                true, // legend
                true, // tooltips
                false // urls
                );
        chart.setBackgroundPaint(new Color(0xff, 0xff, 0xcc));
        ChartFrame frame = new ChartFrame("Gantt Chart", chart);
        frame.setVisible(true);
        frame.setSize(400, 350);
    }

    private static class SubTask {
        private String taskId;
        private String startDate;
        private String endDate;

        public SubTask(String taskId, String startDate, String endDate) {
            super();
            this.taskId = taskId;
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }
}