setContentView(R.layout.activity_phone__login);
    mAuth = FirebaseAuth.getInstance();
    InitVariables();
    AddPhoneNumberButtons();

    mcallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            signInWithPhoneAuthCredential(phoneAuthCredential);
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

            Toast.makeText(getBaseContext(), "Wrong Or Invalid Phone Number...", Toast.LENGTH_SHORT).show();
            AddPhoneNumberButtons();
            if (e instanceof FirebaseAuthInvalidCredentialsException) {
                Toast.makeText(getBaseContext(), "Invalid Request " + e.toString(), Toast.LENGTH_SHORT).show();
            } else if (e instanceof FirebaseTooManyRequestsException) {
                Toast.makeText(getBaseContext(), "The SMS quota for the project has been exceeded " + e.toString(), Toast.LENGTH_SHORT).show();
            }


        }
        @Override
        public void onCodeSent(String verificationId,
                               PhoneAuthProvider.ForceResendingToken token) {
            // Save verification ID and resending token so we can use them later
            verificationid = verificationId;
            mresendtoken = token;
            Toast.makeText(getBaseContext(), "Code Sent Please Check Your SMS...", Toast.LENGTH_SHORT).show();
            AddVerifyButtons();

        }
    };