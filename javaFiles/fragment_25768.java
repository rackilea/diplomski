AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
builder.setTitle(R.string.title) //
        .setMessage(R.string.message) //
        .setPositiveButton(getString(R.string.positive), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // TODO
                dialog.dismiss();
            }
        }) //
        .setNegativeButton(getString(R.string.parking_no_button), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // TODO
                dialog.dismiss();
            }
        });
builder.show();