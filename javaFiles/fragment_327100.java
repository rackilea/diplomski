Dialogs dialog = new Dialogs(MainActivity.this);
        dialog.consigna(new Dialogs.OnConfirm() {
            @Override
            public void onConfirm(String s) {

                Log.d("data", s);
            }
        });