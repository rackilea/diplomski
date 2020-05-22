int day = datepicker.getDayOfMonth();
    Intent intent = new Intent (OneWeekPlan.this, Save_File.class);
    intent.putExtra("day", day);
    intent.putExtra("wk1month", month);
    intent.putExtra("wk1year", year);
    intent.putExtra("wk1dayofweek", wk1dayofweek);
    startActivity(intent);