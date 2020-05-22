new Date().getTime();
//------- OR
long dtMili = System.currentTimeMillis();
Date dt = new Date(dtMili);
Calendar cal = Calendar.getInstance();
cal.setTime(dt);
cal.getTime(); //-------- This will give you the timestamp.