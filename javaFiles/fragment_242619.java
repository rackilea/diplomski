if (weChangedIt) {
     weChangedIt = false;
} else {
    if(s.toString().charAt(s.length()-1) != 'a'){
        weChangedIt = true;
        freaktext=freaktext+s.toString().charAt(s.length()-1);
        txtfreak.setText(s.toString().substring(0, s.length()-1) + "a"); 
        txtfreak.setSelection(txtfreak.getText().length());
    }else{
        freaktext=freaktext+"a";
    }
}