Calendar theEnd = Calendar.getInstance();
Calendar theStart = (Calendar) theEnd.clone();

theStart.add(Calendar.DAY_OF_MONTH, -30);

SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
String start = dateFormat.format(theStart.getTime());
String end = dateFormat.format(theEnd.getTime());

// Now you have date boundaries in TEXT format

Cursor cursor = db.rawQuery("SELECT * FROM table WHERE timestamp BETWEEN "+start+" AND "+end);