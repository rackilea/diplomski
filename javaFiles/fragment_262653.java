private void showRules() {

    final Dialog ruleDialog = new Dialog(this);
    ruleDialog.setContentView(R.layout.ruledialog);

    Button cancelbtn = (Button)ruleDialog.findViewById(R.id.cancelbtn);
    //cancelbtn.setOnClickListener(this);
    cancelbtn.setOnClickListener(new OnClickListener() {
        public void onClick(View arg0) {
            ruleDialog.dismiss();

        }
    });

    ruleDialog.setCancelable(true);
    ruleDialog.show();
    //dialog.setTitle("How");
    }