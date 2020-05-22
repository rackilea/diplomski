new AlertDialog.Builder(getContext())
                .setTitle(R.id.dialog_title)
                .setMessage(R.id.dialog_message)
                .setPositiveButton(R.id.positive_text, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                     //do onClick stuff here   
                    }
                })
                .show();