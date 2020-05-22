XAxis xAxis = mLineChart.getXAxis();
xAxis.setValueFormatter((value, axis) -> {
            Long time = (long) (value * xCoefficient + xMin);
            Date date = new Date(time);
            DateFormat format;
            if(mInterval == Interval.OneHour || mInterval == Interval.SixHours || mInterval == Interval.OneDay){
                format = android.text.format.DateFormat.getTimeFormat(getContext());
            }
            else {
                format = android.text.format.DateFormat.getDateFormat(getContext());
            }
            return format.format(date);
        });