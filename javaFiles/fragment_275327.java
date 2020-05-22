final AlertDialog.Builder alertDialog = new AlertDialog.Builder(
        Task1Activity.this);
alertDialog.setTitle("Unlucky!");
alertDialog.setCancelable(false)
alertDialog.setMessage("You have guessed incorrectly three times. " +
           "The answer was " + ranNum + ". " + "Would you like to play again?");
alertDialog.setPositiveButton("YES",
        new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)        {
                 Intent i = new Intent(Task1Activity.this, Task1Activity.class);
                 i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(i);
            }
        });
alertDialog.setNegativeButton("NO",
        new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialog.dismiss();   
                //getActivity().finish();
                finishAffinity();   //finish all previous activity on stack
            }
        });
alertDialog.show();