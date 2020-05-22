fab_play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String text = btnAdd.getText().toString();

               if(text.equalsIgnoreCase("Play")){
                  //your code
                   fab_play_pause.setText("pause")
               }
              else if(text.equalsIgnoreCase("pause"))
               {
                  //your code
                  fab_play_pause.setText("Play")
               }
            }
        });