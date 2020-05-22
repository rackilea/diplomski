public class FcmService extends FcmService {
    @Override
    public void onMessageReceived(@NotNull RemoteMessage remoteMessage) {
        if (!remoteMessage.getData().isEmpty()){
            // data message
            // start a service or handle it the way you want
        }

        if (remoteMessage.getNotification() != null){
            // notification message
        }
    }
}