@Override
public void onDestroy() {
    ...
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
          stopForeground(true); //true will remove notification
    }
    ...
}