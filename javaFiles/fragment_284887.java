PendingIntent pendingIntent = null;
    if (authorized) {
        Intent action = new Intent(context, SpecificPhotoActivity.class);

        pendingIntent = TaskStackBuilder.create(context)
                .addNextIntentWithParentStack(action)
                .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
    } else {
        Intent action = new Intent(context, IntroActivity.class);
        action.putExtra("photos_flow", true);
        pendingIntent = PendingIntent.getActivity(context, 0, action, 0);
    }