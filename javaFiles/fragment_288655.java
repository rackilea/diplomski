public void _showhint(View vw)
    {
        final Dialog showHintDialog = new Dialog(activity);

        showHintDialog.setContentView(R.layout.custom_dialog);
        showHintDialog.setTitle("How to enter data");

        showHintDialog.show();
        btnClose = (Button) showHintDialog.findViewById(R.id.button) ;
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                showHintDialog.dismiss();
            }
        });
    }