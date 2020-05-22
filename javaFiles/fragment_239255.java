public class FetchUnreadMailService extends Service {

    private NotificationManager mNotificationManager;
    private int SIMPLE_NOTFICATION_ID;
    private Timer myTimer;
    Session mySession;      
    int unread_count = 0;

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {

                    mySession = new Session();
                     if(mySession.getStatus()){
                            APIHelper api = new APIHelper();
                            unread_count =  (Integer) api.getMailBoxNotification(mySession.getUserId());
                            }
                        if(unread_count>0){
                            mNotificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                            Intent notifyIntent = new Intent(FetchUnreadMailService.this,MailBox.class);
                            Context context = getApplicationContext();
                            CharSequence contentTitle = "New Mail";
                            CharSequence contentText = "You Have ("+ unread_count +") unread mails";
                            PendingIntent intent = PendingIntent.getActivity(FetchUnreadMailService.this, 0,notifyIntent, android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
                            final Notification notifyDetails = new Notification(R.drawable.youtube,"New Alert, Click Me!",System.currentTimeMillis());  
                            notifyDetails.setLatestEventInfo(context, contentTitle, contentText, intent);
                            notifyDetails.flags= Notification.FLAG_AUTO_CANCEL;//for auto cancel notification
                            mNotificationManager.notify(SIMPLE_NOTFICATION_ID, notifyDetails);  
                            }   




            }

        }, 0, 30000);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service destroyed ...", Toast.LENGTH_LONG).show();
    }






}