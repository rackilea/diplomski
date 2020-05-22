final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.camgaldialog);
                dialog.setTitle("Complete action using");
                Button dialogcam = (Button) dialog.findViewById(R.id.Bcam);
                dialogcam.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View view0) {
                        // TODO Auto-generated method stub
                        Intent i = new Intent(
                                android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(i, 0);
                        dialog.dismiss();
                    }

                });
                dialog.show();
                break;