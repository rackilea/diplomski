public class Validation {

    public boolean isEmailValid(CharSequence email){
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public void validateMobile(String mobile){
        if (mobile != null){
            if (mobile.length() > 10){
                //do stuff with name
            }
        }
    }

    public void validatePassword(String password, String retypePassword){
        if (password != null && retypePassword != null){
            if (password.equals(retypePassword)){
                //do stuff with password
            }
        }
    }

}