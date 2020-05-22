val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !notificationManager.isNotificationPolicyAccessGranted) {

        val intent = Intent(
                android.provider.Settings
                        .ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)

        startActivity(intent)
}