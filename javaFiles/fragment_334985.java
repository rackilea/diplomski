for(int x=0; x<itemAmt; x++){
    final int myX = x;
    btn[0][x].setOnClickListener(new Button.OnClickListener(){
        public void onClick(View v) {

            int num=Integer.parseInt(et[myX].getText().toString());
            num++;

        }

    });

    btn[1][x].setOnClickListener(new Button.OnClickListener(){
        public void onClick(View v) {

            int num=Integer.parseInt(et[myX].getText().toString());
            num--;

        }

    });
    }