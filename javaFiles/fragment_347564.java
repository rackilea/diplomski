Handler handler = new Handler(Looper.getMainLooper());

Timer timer = new Timer();
timer.scheduleAtFixedRate(new TimerTask() {
    public void run() {
        data = bw.getAttendanceFromDB(term, course,sections,day);
    }
}, 0, 5 * 1000);

handler.post(new Runnable() {
    public void run() {
        ArrayList<Properties> attendanceusers = attendanceUse(data);
        addAttendance(attendanceusers);  
    }
})