try {
    alarmManagerstop.cancel(getSendLocationIntent(context, 0));
    getSendLocationIntent(context, 0).cancel();
} catch (Exception e) {
    e.printStackTrace();
}