public void exportEventToCalendar() {
    try {
        SimpleDateFormat startFormat = new SimpleDateFormat(getString(R.string.date_format));
        startFormat.setTimeZone(TimeZone.getDefault());
        Date dateS = startFormat.parse(Methods.getMethods().getDate(getActivity(), helper.events.get(position).optLong("starts"), R.string.date_format));
        long start = dateS.getTime();

        SimpleDateFormat endFormat = new SimpleDateFormat(getString(R.string.date_format));
        endFormat.setTimeZone(TimeZone.getDefault());
        Date dateE = endFormat.parse(Methods.getMethods().getDate(getActivity(), helper.events.get(position).optLong("ends"), R.string.date_format));
        long end = dateE.getTime();

        Log.e("Start", "" + start);
        Log.e("Ends", "" + end);

        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, start);
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
        intent.putExtra(CalendarContract.Events.TITLE, helper.events.get(position).optString("name"));
        intent.putExtra(CalendarContract.Events.DESCRIPTION,  helper.events.get(position).optString("description"));
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, helper.events.get(position).optString("address"));
        startActivity(intent);

    } catch (ParseException e) {
        e.printStackTrace();
    }
}