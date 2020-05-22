public class MyDialogBuilder {

    String caption;
    String input;
    Context mContext;
    boolean showToast;

    public MyDialogBuilder(String caption, Context mContext) {
        this.caption = caption;
        this.mContext = mContext;
    }

    MyDialogBuilder setInputValue(String value) {
        this.input = value;
        return this;
    }

    MyDialogBuilder createEditTextInputDialog() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View inputDialogView = inflater.inflate(R.layout.dialog_input_edittext, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setView(inputDialogView);

        final EditText etInput = (EditText) inputDialogView.findViewById(R.id.et_inputdialog);
        final TextView tvCaption = (TextView) inputDialogView.findViewById(R.id.tv_inputdialog_caption);

        tvCaption.setText(caption);

        builder.setCancelable(true)
                .setPositiveButton(R.string.apply, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setInputValue(etInput.getText().toString());

                        // Toast here
                        if (showToast) {
                            Toast.makeText(mContext, input, Toast.LENGTH_SHORT).show();
                        }
                    }
                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        return this;

    }

    MyDialogBuilder toastInput() {
        // Set here to show toast or not
        showToast = true;
        return this;
    }

}