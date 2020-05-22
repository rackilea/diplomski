String[] colurs ={"Red","Blue","Green"};

AlertDialog.Builder builder = new AlertDialog.Builder(this);

builder.setTitle("Pick Colour")
        .setItems(colurs, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // The 'which' argument contains the index position
                // of the selected item
            }
        });
if(currentThreadTimeMillis()>1000){
    colurs[0]="New1";
    colurs[1]="New2";

    builder.setTitle("Pick Colour").setItems(colurs, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            // The 'which' argument contains the index position
            // of the selected item
        }
    });
}
builder.create();
builder.show();