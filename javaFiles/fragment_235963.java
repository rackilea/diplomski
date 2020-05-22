long endBidTime = .... // today at 12:00:00
long currentTime = System.currentTimeMillis();
long remaining = currentTime - endBidTime;
long hours = remaining / 3600000;
long mins = remaining / 60000 % 60;
long seconds = remaining / 1000 % 60;
String remainingText = "%02d:%02d:%02d".format(hours,mins,seconds);