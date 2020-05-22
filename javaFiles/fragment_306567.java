class CustomNotificationListener implements javax.management.NotificationListener {
        @Override
        public void handleNotification(Notification notification, Object handback) {
            // hook your logic here.
          String notifType = notification.getType();
          if (notifType.equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION)) {
              // retrieve the garbage collection notification information
              CompositeData cd = (CompositeData) notification.getUserData();
              GarbageCollectionNotificationInfo info = GarbageCollectionNotificationInfo.from(cd);
              System.out.println(info.getGcInfo().getDuration());
          }
        }
}