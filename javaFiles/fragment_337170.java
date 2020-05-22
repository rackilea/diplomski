final String password = etregpassword.getText().toString();
final String confirmPassword = etconfirmregpassword.getText().toString();
if (!TextUtils.isEmpty(password) && !TextUtils.isEmpty(confirmPassword))
    {
        if(password.equals(confirmPassword))
        {
            //are equal
        }
        else {
            //are different
        }
    }