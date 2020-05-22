public List<Model> getDailyData(List<DailyData> data) throws ParseException {

    List<Model> modelList = new ArrayList<Model>();

    String pattern = "yyyy-MM-ddHH:mm:ss";

    double[] occurenceOfDateRange = {0.0, 0.0, 0.0,
        0.0, 0.0, 0.0,
        0.0, 0.0, 0.0,
        0.0, 0.0, 0.0};
    double[] percentages = {0.0, 0.0, 0.0,
        0.0, 0.0, 0.0,
        0.0, 0.0, 0.0,
        0.0, 0.0, 0.0};

    if (data != null) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        for (int num = 0; num < data.size(); num++) {
            Calendar recordDate = Calendar.getInstance();
            recordDate.setTime(
                    new SimpleDateFormat(pattern).parse(data.get(num).getCheckDate()));

            percentages[recordDate.get(Calendar.HOUR_OF_DAY) / 2] += data.get(num).getPercentage();
            occurenceOfDateRange[recordDate.get(Calendar.HOUR_OF_DAY) / 2] += 1;

        }

        Calendar base = Calendar.getInstance();
        base.set(Calendar.HOUR, 0);

        for (int i = 0; i < 12; i++) {
            Model model = new Model();
            model.setDate_time_stamp(df.format(base));
            if (occurenceOfDateRange[i] != 0) {
                model.setAvgPerc(percentages[i] / occurenceOfDateRange[i]);
            } else {
                model.setAvgPerc(0);
            }
            modelList.add(model);
            base.set(Calendar.HOUR, base.get(Calendar.HOUR) + 2);
        }
    }

    return modelList;
}