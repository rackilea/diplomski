NotificationService svc = ...;
UserId userId = ...;

AsyncHandler<Notification> handler = new AsyncHandler<Notification>()
{
    public void handleResponse (Response<Notification> response)
    {
       Notification notification = response.get();

       // update swing gui

       NotificationID notificationId = notifcation.getId();

       svc.markNotificationAsSeen(userId, notificationId);

       // continue polling forever (or put in some logic to stop)
       svc.getNotificationAsync(userId, this);
    }
};

Future<?> invocation = svc.getNotificationAsync(userId, handler);