/**
 * Send automatic server pings with the help of {@link AlarmManager}.
 * <p>
 * Smack's {@link PingManager} uses a <code>ScheduledThreadPoolExecutor</code> to schedule the
 * automatic server pings, but on Android, those scheduled pings are not reliable. This is because
 * the Android device may go into deep sleep where the system will not continue to run this causes
 * <ul>
 * <li>the system time to not move forward, which means that the time spent in deep sleep is not
 * counted towards the scheduled delay time</li>
 * <li>the scheduled Runnable is not run while the system is in deep sleep.</li>
 * </ul>
 * That is the reason Android comes with an API to schedule those tasks: AlarmManager. Which this
 * class uses to determine every 30 minutes if a server ping is necessary. The interval of 30
 * minutes is the ideal trade-off between reliability and low resource (battery) consumption.
 * </p>
 * <p>
 * In order to use this class you need to call {@link #onCreate(Context)} <b>once</b>, for example
 * in the <code>onCreate()</code> method of your Service holding the XMPPConnection. And to avoid
 * leaking any resources, you should call {@link #onDestroy()} when you no longer need any of its
 * functionality.
 * </p>
 */