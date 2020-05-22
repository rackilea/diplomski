final Calendar cal= new GregorianCalendar();
Thread clock= new Thread(){
public void run(){
    for (;;) {
        //// add this line
        cal.setTimeInMillis(System.currentTimeMillis());
        /////
        int am=cal.get(Calendar.AM_PM);
        int hr=cal.get(Calendar.HOUR);
        int min=cal.get(Calendar.MINUTE);
        int sec=cal.get(Calendar.SECOND);
        if (am==0) {
            jtime_Label.setText(""+hr+":"+min+":"+sec+" AM");
        } else {
            jtime_Label.setText(""+hr+":"+min+":"+sec+" PM");
        }
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int mon=cal.get(Calendar.MONTH);
        int year=cal.get(Calendar.YEAR);
        date_label.setText(""+day+"-"+(mon+1)+"-"+year);
        }
    }
};
clock.start();