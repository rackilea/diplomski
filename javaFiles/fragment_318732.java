String[] descriptionArray={"this is button 1","this is button 2"};

//set onclick listener to your button
button1.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {

            dis.setText(descriptionArray[0]);
    }
});

button2.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {

            dis.setText(descriptionArray[1]);
    }
});