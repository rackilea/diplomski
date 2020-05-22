if (time != null && !time.equals("")) {
    StringTokenizer st = new StringTokenizer(time, ":");
    String timeHour = st.nextToken();
    String timeMinute = st.nextToken();

    timePickDialog = new TimePickerDialog(v.getContext(),
        new TimePickHandler(), Integer.parseInt(timeHour),
        Integer.parseInt(timeMinute.replace(" am","").replace(" pm","")), true);
}