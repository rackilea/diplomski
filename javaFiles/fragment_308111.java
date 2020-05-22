final AlertDialog dialog = new AlertDialog.Builder(this)
            .setView(addDialogView)
            .create();

            addDialogView.findViewById(R.id.add_confirm).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view2) {
                    if ( addItemNameTxt.getText().length() == 0 )
                    {
                        Toast.makeText(MainActivity.this, "Text cannot be empty", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    String itemName = addItemNameTxt.getText().toString();
                    String itemCount = addItemCountTxt.getText().toString();

                    dbHelper.insertTask(itemName, Integer.parseInt(itemCount));
                    taskAdapter.swapCursor(dbHelper.getTasks());

                    Snackbar.make(view, String.format("Added \"%s (%s)\" to list", itemName, itemCount), Snackbar.LENGTH_LONG).show();

                    dialog.dismiss();
                }
            });
            dialog.show();