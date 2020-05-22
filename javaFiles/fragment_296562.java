private void askForPublishActionsForScores() {
    new AlertDialog.Builder(MainActivity.this)
            .setPositiveButton("بله",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            // User hit OK. Request Facebook friends
                            // permission.
                            requestPublishPermissions();
                        }
                    })
            .setNegativeButton("خیر",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User hit cancel.


                        }
                    }).setTitle(R.string.publish_scores_dialog_title)
            .setMessage(R.string.publish_scores_dialog_message).show();
 }