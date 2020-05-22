Button button1;
Button button2;



        //set a onClickListener on button1 
  button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (button2.getVisibility() == View.VISIBLE){
                button2.setVisibility(View.INVISIBLE);
                } else button2.setVisibility(View.VISIBLE);
            }

});