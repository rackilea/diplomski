newBt.setId(id to set) // Should be positive, doesn't have to be unique
newBt.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //The View carries the Id
                v.getId();
                //Then you can simply set up a fast Switch-case for example
                switch (v.getid()) {
                case 1:
                       break;
                default:
                       break;
            }
        });