holder.buttonone.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ((GridView)parent).performItemClick(v,position,0);

        }
    });
 holder.buttontwo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ((GridView)parent).performItemClick(v,position,0);

        }
    });//further for your 15 buttons