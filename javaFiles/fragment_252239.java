Intent notificationIntent = new Intent("android.media.action.DISPLAY_NOTIFICATION");
notificationIntent.addCategory("android.intent.category.DEFAULT");
notificationIntent.putExtra("ProdName",ProdName);
notificationIntent.putExtra("ProdDesc",ProdDesc);
notificationIntent.putExtra("ProdID",ProdID);

PendingIntent broadcast = PendingIntent.getBroadcast(this, REQUEST_CODE, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);