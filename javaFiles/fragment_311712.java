/**
 * Persistent notification on the status bar,
 *
 * @param tag An string identifier for this notification unique within your
 *        application.
 * @param notification A {@link Notification} object describing how to
 *        notify the user, other than the view you're providing. Must not be null.
 * @return the id of the notification that is associated with the string identifier that
 * can be used to cancel the notification
 */
public void notify(String tag, int id, Notification notification)
{
    int[] idOut = new int[1];
    INotificationManager service = getService();
    String pkg = mContext.getPackageName();
    if (localLOGV) Log.v(TAG, pkg + ": notify(" + id + ", " + notification + ")");
    try {
        service.enqueueNotificationWithTag(pkg, tag, id, notification, idOut);
        if (id != idOut[0]) {
            Log.w(TAG, "notify: id corrupted: sent " + id + ", got back " + idOut[0]);
        }
    } catch (RemoteException e) {
    }
}