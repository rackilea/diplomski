alertDialog.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int item) {
            if (items[item] == "X") {
                First = 1;
                //Toast.makeText(getApplication(), "Computer goes first.", Toast.LENGTH_SHORT).show();
            } else if (items[item] == "O") {
                First = 2;
                if (First == 2) {
                    //    Toast.makeText(getApplication(), "2 WORKS", Toast.LENGTH_SHORT).show();
                }
            }
            dialog.dismiss();

            if (First == 1) {
                Toast.makeText(getApplication(), "Inside If", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplication(), "After If Message", Toast.LENGTH_SHORT).show();
            }


        }
    });

alertDialog.show();