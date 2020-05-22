char[] passwordInput = passwordText.getPassword();
if ((userText.getText()).equals(USERNAME)&& 
    (Arrays.equals(password.toCharArray(), passwordInput)) {
    //do something
} else {
    //do something else, e. g. inform the user about the error
}
Arrays.fill(passwordInput, '0'); //clearing out password from memory