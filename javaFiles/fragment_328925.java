public static DialogPlus showDialog(Context context) {
        DialogPlus dialog = DialogPlus.newDialog(context)
                .setContentHolder(new ViewHolder(R.layout.content))
                .create();
                //
        dialog.show();
        return dialog;

    }