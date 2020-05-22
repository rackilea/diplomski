@Override
  public synchronized void reportNotification(int processId, String channelName, String payload) {

    Iterator<Map.Entry<NotificationKey, WeakReference<NotificationListener>>> iter = notificationListeners.entrySet().iterator();
    while (iter.hasNext()) {

      Map.Entry<NotificationKey, WeakReference<NotificationListener>> entry = iter.next();

      NotificationListener listener = entry.getValue().get();
      if (listener == null) {

        iter.remove();
      }
      else if (entry.getKey().channelNameFilter.matcher(channelName).matches()) {

        listener.notification(processId, channelName, payload);
      }

    }

}