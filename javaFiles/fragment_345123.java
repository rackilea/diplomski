class Authenticator {

    login(String username, String password){
        User user = retrieveUserFromDatabase(username);
        throwIfWrongpassword(user, password);
        verifyUserAge(user)
    }

    void throwIfWrongpassword(User user, String password){
        //throws AuthenticationException if password is wrong
    }

    void verifyUserAge(User user){
        //verify that user is above 18 or account is authorized by a parent
    }

    void biometricLogin(String username, BiometricImage bioimg){
        User user = retrieveUserFromDatabase(username);
        verifyBiometricImage(user, password);
        verifyUserAge(user);
    }
}