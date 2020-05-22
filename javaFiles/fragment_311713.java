/**
 * Persistent notification on the status bar,
 *
 * @param id An identifier for this notification unique within your
 *        application.
 * @param notification A {@link Notification} object describing how to
 *        notify the user, other than the view you're providing. Must not be null.
 */
public void notify(int id, Notification notification)
{
    notify(null, id, notification);
}