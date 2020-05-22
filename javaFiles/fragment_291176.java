FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final Dialog addDialog = new Dialog(this);
            addDialog.setContentView(R.layout.dialogedit);
            final Button butEditAdd =(Button)addDialog.findViewById(R.id.btn);
            //final Button butEditAdd=addDialog.getAdd();
            addDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            butEditAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //addDialog.dismiss();
                    Toast.makeText(getApplicationContext(),"It's working", Toast.LENGTH_SHORT).show();
                }
            });
            addDialog.show();
        }
    });