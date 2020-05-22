final CharSequence date = DateFormat.format(mDateFormat, mCalendar);
    final CharSequence day = DateFormat.format(mDayFormat, mCalendar);
    String time = (String) DateFormat.format(mTimeFormat, mCalendar);
    RemoteViews views = new RemoteViews(getPackageName(), R.layout.clock2by2);
    String days = new String(day.toString().substring(0,1).toUpperCase() + day.toString().substring(1));
    String dates = new String(date.toString().substring(0,1).toUpperCase() + date.toString().substring(1));

    views.setTextViewText(R.id.Day, days);
    views.setTextViewText(R.id.Date, dates);
    views.setImageViewBitmap(R.id.TimeView, buildUpdate(time));