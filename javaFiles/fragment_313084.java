public void SetupRoastFirebase(){
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference roastRef = database.getReference(ROAST_KEY);

    roastRef.addChildEventListener(new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            Roast addedRoast = dataSnapshot.getValue(Roast.class);
            BroasterLogger.LogDebugMessage("New Roast added");

            Gson gson = new Gson();
            Intent broadcastIntent = new Intent(NEW_ROAST_READY);
            broadcastIntent.putExtra(ROAST_KEY, gson.toJson(addedRoast));
            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(broadcastIntent);

            NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

            User loggedInUser = _settingsRepository.GetLoggedInUser();
            if (loggedInUser == null)
                return;

            if (addedRoast.UserId.equals(loggedInUser.UserId))
            {
                BroasterLogger.LogDebugMessage("Logged in user was roasted! Posting notification!");

                if (!addedRoast.DeliveredRoastToRecipient)
                    _roastsRepository.NotifyReceived(addedRoast.RoastId);

                if (!addedRoast.DeliveredRoastToRecipient)
                {
                    // Clicking intents heavily inspired from: https://stackoverflow.com/questions/10184351/how-to-start-activity-when-user-clicks-a-notification
                    Intent myRoastsActivity = new Intent(getApplicationContext(), MyProfileActivity.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, myRoastsActivity,
                            PendingIntent.FLAG_CANCEL_CURRENT);


                    NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(), getString(R.string.channel_id))
                            .setContentTitle(getString(R.string.notification_title))
                            .setContentText(getString(R.string.notification_description))
                            .setContentIntent(pendingIntent)
                            .setSmallIcon(R.mipmap.ic_launcher_round);

                    notificationManager.notify(101, notification.build());
                }
            }
        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            Roast addedRoast = dataSnapshot.getValue(Roast.class);
            BroasterLogger.LogDebugMessage("Roast changed");
            HandleAddedRoast(AddedRoast);
        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });