AlertDialog alertDialog = new AlertDialog.Builder(this,R.style.myBackgroundStyle).create();
        alertDialog.setTitle("Exit Alert");
        alertDialog.setMessage("Do you really want to exit the Game?");
        alertDialog.setButton("Quit", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //Best way is firstly use finish() and after that use System.exit(0) to clear static variables. It will give you some free space.
                // A lot of applications leave working processes and variables what makes me angry. After 30 minutes of using memory is full and i have to run Task Manager - Lvl 2 clear memory
                finish();
                System.exit(0);
                return;

            }
        });


//New part regarding the back key when only dialog is shown.
alertDialog.setOnKeyListener(new Dialog.OnKeyListener() {

        @Override
        public boolean onKey(DialogInterface arg0, int keyCode,
                KeyEvent event) {

            if (keyCode == KeyEvent.KEYCODE_BACK) {

                alertDialog.dismiss();
            }
            return true;
        }
    });