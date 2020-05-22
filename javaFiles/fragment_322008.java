fun pendingIntent(context: Context): PendingIntent {
    return NavDeepLinkBuilder(context)
       .setGraph(R.navigation.your_navigation)
       .setDestination(R.id.android)
       .createPendingIntent()
}