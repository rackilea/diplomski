public void enableSubmitIfReady() {

        Button login_button = (Button) findViewById(R.id.login_button);

        if(login_activation_code.toString().trim().length()==0){
            login_button.setClickable(false);
            login_button.setBackgroundColor(getResources().getColor(R.color.holo_light_green));// change color here so it's look like button disable
        } else {
            login_button.setClickable(true);
            login_button.setBackgroundColor(getResources().getColor(R.color.holo_dark_green));
        }
    }