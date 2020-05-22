class LogInViewModel : ViewModel() {

    /**
     * Two way bind-able fields
     */
    var username: String = ""
    var password: String = ""

    /**
     * To pass login result to activity
     */
    private val logInResult = MutableLiveData<String>()

    fun getLogInResult(): LiveData<String> = logInResult

    /**
     * Called from activity on login button click
     */
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