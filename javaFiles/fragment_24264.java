private static boolean isNotificationListenerServiceEnabled(Context context) { 
     Set<String> packageNames = NotificationManagerCompat.getEnabledListenerPackages(context); 
     if (packageNames.contains(context.getPackageName())) { 
        return true; 
     } 
     return false; 
}