@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode==CODE_AUTHENTICATION_VERIFICATION)
        {
            Toast.makeText(this, "Success: Verified user's identity", Toast.LENGTH_SHORT).show();
            Session.setLock(false);

            startActivity(new Intent(context,WelcomeACtivity.class));

        }
        else if(resultCode == RESULT_CANCELED && requestCode == CODE_AUTHENTICATION_VERIFICATION)
        {
            finish();
        }
        else
        {
            Toast.makeText(this, "Failure: Unable to verify user's identity", Toast.LENGTH_SHORT).show();

        }
    }