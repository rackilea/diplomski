try
    {
        final EditText editText = new EditText(this);
        DialogInterface.OnClickListener ConfirmProductClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    String url = editText.getText().toString(); 
                    break;
                case DialogInterface.BUTTON_NEUTRAL:
                    dialog.cancel();
                    break;
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.app_label3));
        builder.setView(editText).setPositiveButton(getResources().getString(R.string.app_labe1), // txtDesc it's a EditTextConfirmProductClickListener)
        .setNeutralButton(getResources().getString(R.string.app_label2), ConfirmProductClickListener)
        .show();

    }
    catch (Exception exc)
    {
        Log.e("ex", exc.toString());
    }