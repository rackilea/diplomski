if(rb.isChecked()){
    rb.setChecked(true);
    SelectRoomActivity.bundle.putBoolean("local",true);
}
else{
    rb.setChecked(false);
    SelectRoomActivity.bundle.putBoolean("local",false);
}