int currentPosition = 0 ;
        final String [] array = new String[10];
        for(int i =0 ; i<array.length ; i++){
            final Handler handler = new Handler();
            final int  position = i ;
            currentPosition = position ;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    textView.setText(array[position]);
                }
            }, 5000);
        }


        final int position = currentPosition ; 
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(array[position]);
            }
        });