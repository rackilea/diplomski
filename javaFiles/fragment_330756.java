private IntervalXYDataset createIntervalXYDataset()  {


        TimePeriodValuesCollection result = new TimePeriodValuesCollection();
        TimePeriodValues s1 = new TimePeriodValues("Daily Holding Time");

        if (holdTimeRptList != null && holdTimeRptList.size() > 0
                && graphList != null && graphList.size() > 0) {

            for (String graph : graphList) {
                s1 = new TimePeriodValues(graph);
                for (reportDto reportDto : holdTimeRptList) {
                    if (reportDto != null
                            && reportDto.getHoldTime() != 0
                            && reportDto.getGraphTime() != null
                            && reportDto.getGraphTime().equalsIgnoreCase(
                                    graph)) {

                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                        Date dt=formatter.parse(reportDto.getHoldEntry());
                        Date dt1=DateUtils.addHours(dt, 5);

                        s1.add(new SimpleTimePeriod(dt, dt1), Integer.valueOf(reportDto.getHoldTime()));

                    }
                }
                result.addSeries(s1);
            }                   
        }

        return result;
    }