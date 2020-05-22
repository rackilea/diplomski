public void setDate (TextView view){

    Date today = Calendar.getInstance().getTime();//getting date
    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");//formating according to my need
    String date = formatter.format(today);
    view.setText(date);
}