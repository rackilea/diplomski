AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Opponents:");

    LinearLayout layout = new LinearLayout(this);
    layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT));
    layout.setOrientation(LinearLayout.VERTICAL);

    final EditText[] input = new EditText[NumberOfPlayers];
    for (int aux=0;aux<NumberOfPlayers;aux++) {
        input[aux] = new EditText(MainActivity.this);
        input[aux].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        input[aux].setInputType(InputType.TYPE_CLASS_TEXT);
        layout.addView(input[aux]);
    }

    builder.setView(layout); // this is a set method, not add

    // Set up the buttons
    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            for (int aux=0;aux==NumberOfPlayers;aux++){
                //PlayersTXT[aux].setText(input[aux].getText().toString());
            }
        }
    });
    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    });

    builder.show();