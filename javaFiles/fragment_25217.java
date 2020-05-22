private int counter = 0;
btn_take_photo.setOnClickListener(new FloatingActionButton.OnClickListener() {
            @Override
            public void onClick(View view) {                
                counter++;
                count.setText(String.valueOf(counter));
                cameraimage();
            }
        });
             @Override
            public void onPictureTaken(byte[] bytes, Camera camera) {
                String Counting = count.getText().toString().trim();
                String text = cardnumberbox.getText().toString().trim();
                {
                    if(text.substring(0,1).startsWith("K"))
                    {
                        text =  Counting+text.substring(1);
                    }
                    else
                    {
                        text=  Counting+text ;//.substring(0));
                    }
                }

                String photofile =text + ".jpg";