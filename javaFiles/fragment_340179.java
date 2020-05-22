private static final String ACTION_TOGGLE_PLAYBACK = "com.your.package.name.TOGGLE_PLAYBACK";
private static final String ACTION_PREV = "com.your.package.name.PREV";
private static final String ACTION_NEXT = "com.your.package.name.NEXT";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ...

    final Bitmap artwork = ...;

    // Create a new MediaSession
    final MediaSession mediaSession = new MediaSession(this, "debug tag");
    // Update the current metadata
    mediaSession.setMetadata(new MediaMetadata.Builder()
            .putBitmap(MediaMetadata.METADATA_KEY_ALBUM_ART, artwork)
            .putString(MediaMetadata.METADATA_KEY_ARTIST, "Pink Floyd")
            .putString(MediaMetadata.METADATA_KEY_ALBUM, "Dark Side of the Moon")
            .putString(MediaMetadata.METADATA_KEY_TITLE, "The Great Gig in the Sky")
            .build());
    // Indicate you're ready to receive media commands
    mediaSession.setActive(true);
    // Attach a new Callback to receive MediaSession updates
    mediaSession.setCallback(new MediaSession.Callback() {

        // Implement your callbacks

    });
    // Indicate you want to receive transport controls via your Callback
    mediaSession.setFlags(MediaSession.FLAG_HANDLES_TRANSPORT_CONTROLS);

    // Create a new Notification
    final Notification noti = new Notification.Builder(this)
            // Hide the timestamp
            .setShowWhen(false)
            // Set the Notification style
            .setStyle(new Notification.MediaStyle()
                    // Attach our MediaSession token
                    .setMediaSession(mediaSession.getSessionToken())
                    // Show our playback controls in the compat view
                    .setShowActionsInCompactView(0, 1, 2))
            // Set the Notification color
            .setColor(0xFFDB4437)
            // Set the large and small icons
            .setLargeIcon(artwork)
            .setSmallIcon(R.drawable.your_small_icon)
            // Set Notification content information
            .setContentText("Pink Floyd")
            .setContentInfo("Dark Side of the Moon")
            .setContentTitle("The Great Gig in the Sky")
            // Add some playback controls
            .addAction(R.drawable.your_prev_icon, "prev", retreivePlaybackAction(3))
            .addAction(R.drawable.your_pause_icon, "pause", retreivePlaybackAction(1))
            .addAction(R.drawable.your_next_icon, "next", retreivePlaybackAction(2))
            .build();

    // Do something with your TransportControls
    final TransportControls controls = mediaSession.getController().getTransportControls();

    ((NotificationManager) getSystemService(NOTIFICATION_SERVICE)).notify(1, noti);
}

private PendingIntent retreivePlaybackAction(int which) {
    Intent action;
    PendingIntent pendingIntent;
    final ComponentName serviceName = new ComponentName(this, YourPlaybackService.class);
    switch (which) {
        case 1:
            // Play and pause
            action = new Intent(ACTION_TOGGLE_PLAYBACK);
            action.setComponent(serviceName);
            pendingIntent = PendingIntent.getService(this, 1, action, 0);
            return pendingIntent;
        case 2:
            // Skip tracks
            action = new Intent(ACTION_NEXT);
            action.setComponent(serviceName);
            pendingIntent = PendingIntent.getService(this, 2, action, 0);
            return pendingIntent;
        case 3:
            // Previous tracks
            action = new Intent(ACTION_PREV);
            action.setComponent(serviceName);
            pendingIntent = PendingIntent.getService(this, 3, action, 0);
            return pendingIntent;
        default:
            break;
    }
    return null;
}