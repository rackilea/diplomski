// Minimal Fcm Service
class FcmService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        remoteMessage.data.isNotEmpty().let {
            // data message, handle it or start a service
            Intent(this, ConnectionService::class.java).also { intent -> startService(intent) }
        }

        remoteMessage.notification?.let {
        // notification message, you can define your custom notification here or just leave it that way
        }
    }
}