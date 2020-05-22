int seconds = (int) (0.230324074074074 * 24 * 60 * 60);
Calendar cal = Calendar.getInstance();
cal.set(Calendar.HOUR, 0);
cal.set(Calendar.MINUTE, 0);
cal.set(Calendar.SECOND, 0);
cal.add(Calendar.SECOND, seconds);

String result = String.format("%02d:%02d:%02d", 
            cal.get(Calendar.HOUR),
            cal.get(Calendar.MINUTE),
            cal.get(Calendar.SECOND));
System.out.println(result);