if(Boolean.parseBoolean(Flag)) {
    Intent intent=new Intent(PhoneVerificationActivity.this,ConfirmSms.class);
    intent.putExtra("PhoneNumber", Phone);
    startActivity(intent);
    killActivity(); // Here.
}