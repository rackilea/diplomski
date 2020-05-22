Calendar cal = Calendar.getInstance();
cal.set(2012, 8, 29, 10, 0);
long endTime = cal.getTimeInMillis(); 
long currentTime = System.currentTimeMillis();
long remaining = endTime - currentTime;

new CountDownTimer(remaining, 1000) {
...