View view2 = View.inflate(MyActivity.this, R.layout.radiobutton, null);

                AlertDialog.Builder builderconversion = new AlertDialog.Builder(MyActivity.this);
                //builder1.setMessage("Radio Message");
                builderconversion.setView(view2);
                builderconversion.setCancelable(true);
                builderconversion.setPositiveButton("CLOSE",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                //Methods and functions
                                dialog.cancel();
                            }
                        });

                AlertDialog alertconversion = builderconversion.create();
                alertconversion.show();