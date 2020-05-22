newBt.setId(id to set) // Should be positive, doesn't have to be unique
newBt.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Button myClickedButton = (Button) v;
                String buttonText = myClickedButton.getText();

                //Do something with your logic here. 
                //You can also Switch-case on a String ! But AFAIK 
                //it's only possible on Java Compiler 1.7 or above. 
                //But Eclipse will guide you if you want to Switch on String
        });