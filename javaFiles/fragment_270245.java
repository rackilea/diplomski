public void onServiceConnected(ComponentName className, IBinder service) {
        // This is called when the connection with our service has been established, 
        // giving us the service object we can use to interact with our service.
        mBoundService = ((ScheduleService.ServiceBinder) service).getService();
       //call your setcalendar here
        }