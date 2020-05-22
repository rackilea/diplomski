/**
 * Constant to return from {@link #onStartCommand}: if this service's
 * process is killed while it is started (after returning from
 * {@link #onStartCommand}), then leave it in the started state but
 * don't retain this delivered intent.  Later the system will try to
 * re-create the service.  Because it is in the started state, it will
 * guarantee to call {@link #onStartCommand} after creating the new
 * service instance; if there are not any pending start commands to be
 * delivered to the service, it will be called with a null intent
 * object, so you must take care to check for this.
 * 
 * <p>This mode makes sense for things that will be explicitly started
 * and stopped to run for arbitrary periods of time, such as a service
 * performing background music playback.
 */
public static final int START_STICKY = 1;