postButton.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Session session = Session.getActiveSession();
            if (session == null || !session.isOpened()) {
                Log.i(TAG, "Session is null!");
                return;
            }
            List<String> permissions = session.getPermissions();
            if (!permissions.contains("publish_actions")) {
                // the user didn't grant this permission, so we need to
                // prompt them.
                askForPublishActionsForScores();
                return;
            } else {
                ReadAndWriteFBscore.postScore();
            }

        }
    });