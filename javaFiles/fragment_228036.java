alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //What ever you want to do with the value

                        String newCat = edittext.getText().toString();

valuesArrayList.add(newCat);
adapter_exp.notifyDataSetChanged();
                    }
                });