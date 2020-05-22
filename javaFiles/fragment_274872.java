class LogInViewModel : ViewModel() {

    ...

    fun performValidation() {

        if (username.isBlank()) {
            logInResult.value = "Invalid username"
            return
        }

        if (password.isBlank()) {
            logInResult.value = "Invalid password"
            return
        }

        logInResult.value = "Valid credentials :)"
    }

}