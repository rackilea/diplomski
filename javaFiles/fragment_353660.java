public class StickyService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         return Service.START_NOT_STICKY;
    }

}