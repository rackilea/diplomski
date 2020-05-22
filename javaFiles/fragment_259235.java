.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent photoIntent = new Intent(Intent.ACTION_VIEW);

                        File file = new File(imageString);
                        photoIntent.setDataAndType(Uri.fromFile(file),
                                "image/*");

                        context.startActivity(photoIntent);

                    }
                });