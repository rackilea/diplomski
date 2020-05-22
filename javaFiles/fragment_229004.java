BroadcastReceiver receiver=new BroadcastReceiver(){
    @Override
    public void onReceive(Context context, Intent intent) {
          if (audio.getRingerMode()==AudioManager.RINGER_MODE_NORMAL)
          {
              btn1.setText("Silent");
          }
          else if (audio.getRingerMode()==AudioManager.RINGER_MODE_SILENT)
          {
              btn1.setText("Normal");
          }
    }
};

IntentFilter filter=new IntentFilter(AudioManager.RINGER_MODE_CHANGED_ACTION);
registerReceiver(receiver,filter);