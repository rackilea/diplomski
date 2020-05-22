public void setStatus(String value){

    if(textbox!=null){
        textbox.setText(value);
    }else{
        args.putString("status", value);
    }

}