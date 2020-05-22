public String currentDate;

final CaldroidListener listener = new CaldroidListener() {

        @Override
        public void onSelectDate(Date date, View view) {
             currentDate = (String) android.text.format.DateFormat.format("yyyy-MM-dd", date);
        }
   ...
}