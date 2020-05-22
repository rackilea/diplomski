String signUpText = mPreferenceData.getStoreInPreference("signup");
//now you will have data in signupText
button.setOnClickListener(new View.OnClickListener(){        
    if(loginText.getText().toString().trim().equalsIgnoreCase(signUpText)){
        // now loginText whatever data that matches with signUpText will make to login successful
    } else{
        //failure
    }

});