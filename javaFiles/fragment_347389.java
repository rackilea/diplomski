@Override
public void onAuthenticationSucceeded(
        FingerprintManager.AuthenticationResult result) {

    Toast.makeText(appContext,
            "Authentication succeeded.",
            Toast.LENGTH_LONG).show();

    appContext.startActivity(new Intent(appContext,
        EmployeeLoginActivity.class));
}