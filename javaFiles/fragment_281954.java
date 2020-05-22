mPassword.removeTextChangedListener(mPasswordTextWatcher);
phone = mPassword.getText().toString();
phone = formatPhoneNumber(phone);
Log.i("PHONE", "Phone NUMB IS:"+phone);
mPassword.setText(phone);
flag = false;
mPassword.addTextChangedListener(mPasswordTextWatcher);