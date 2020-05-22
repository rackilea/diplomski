public static void apm(MainActivity activity) {
        AlertDialog levelDialog;
        final CharSequence[] items = {" Reboot ", " Reboot Recovery ", " Hot Reboot "};
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("What do you want to do?");
        builder.setCancelable(true);
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {


                switch (item) {
                    case 0:
                        activity.rooted();
                        activity.reboot();
                        break;
                    case 1:
                        activity.rooted();
                        activity.recovery();
                        break;
                    case 2:
                        activity.rooted();
                        activity.softreboot();
                        break;
                    //case 3:
                    //activity.shutdown();
                    //break;
                }
            }
        });
        levelDialog = builder.create();
        levelDialog.show();

}