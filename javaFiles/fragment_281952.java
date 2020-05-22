mPassword.removeTextChangedListener(new InputValidator(mPassword));
                phone = mPassword.getText().toString();
                phone = formatPhoneNumber(phone);
                Log.i("PHONE", "Phone NUMB IS:"+phone);
                mPassword.setText(phone);
                flag = false;
                mPassword.addTextChangedListener(new InputValidator(mPassword));