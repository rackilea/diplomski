final EditText taskEditText = new EditText(this);
final EditText priorityEditText = new EditText(this);
LinearLayout linearLayout = new LinearLayout(this);
linearLayout.setOrientation(LinearLayout.VERTICAL);
linearLayout.addView(taskEditText);
linearLayout.addView(priorityEditText);
AlertDialog dialog = new AlertDialog.Builder(this)
        .setTitle("Add New Task")
        .setMessage("what do you want to do next")
        .setView(linearLayout)
        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String task = String.valueOf(taskEditText.getText());
                String priority = String.valueOf(priorityEditText.getText());
            }
        })
        .setNegativeButton("Cancel", null)
        .create();
dialog.show();