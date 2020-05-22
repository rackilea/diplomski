if(TextUtils.isEmpty(email)){
    //Email is empty!
    Toast.makeText(this,"Please Enter Email",Toast.LENGTH_SHORT).show();
    //Stop function from executing further
    return;
}
else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
    Toast.makeText(context,"Email is badly formatted",Toast.LENGTH_SHORT).show();
}