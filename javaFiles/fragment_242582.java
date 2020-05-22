class MyActivity : Activity(), VerificationListener.OnVerifiedCallback {

    fun onVerified() {
        changeText()
    }

    override fun onCreate(state: Bundle) {
        super.onCreate(state)

        VerificationListener(this).doStuff()

    }

}


class VerificationListener(internal var callback: OnVerifiedCallback) {
    interface OnVerifiedCallback {
        fun onVerified()
    }

    fun whenSomethingGetsVerified() {
        doThings()
        callback.onVerified()
    }
}