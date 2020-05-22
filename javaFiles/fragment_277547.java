boolean invalidPassword = loginCheck.passwordValidator(password.getText()) == -1;
boolean invalidUsername = loginCheck.usernameValidator(username.getText()) == -1;

if (invalidPassword) {
    passwordImg.setImage(fail);
}

if(invalidUsername) {
    usernameImg.setImage(fail);
}

// if at least one of variables is true then submit will be disabled
submit.setDisable(invalidPassword || invalidUsername);