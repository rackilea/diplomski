AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setTitle("Custom view with 4 EditTexts");
        builder.setMessage("AlertDialog");
        builder.setView(R.layout.custom_view);
        //In case it gives you an error for setView(View) try
        builder.setView(inflater.inflate(R.layout.custom_view, null));
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
        return builder.create();