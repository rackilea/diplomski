SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

// Save current time
String savedTime = df.format(new Date()); // Applies local time zone 1

// Check time elapsed
Calendar cal = Calendar.getInstance();
cal.setTime(df.parse(savedTime)); // Applies local time zone 2
cal.add(Calendar.DAY_OF_MONTH, 1); // Adjusts for DST in local time zone 2
if (System.currentTimeMillis() >= cal.getTimeInMillis()) {
    // time has elapsed
}