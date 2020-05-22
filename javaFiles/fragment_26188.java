public void sendVerificationCode(String mobile){
  Log.d("NumberCheck", "The string mobile is - " + mobile); //This should help you identify what the issue is
  CodeBar.setVisibility(View.VISIBLE);
  PhoneAuthProvider.getInstance().verifyPhoneNumber(
          "+55"+mobile,
          60,
          TimeUnit.SECONDS,
          TaskExecutors.MAIN_THREAD,
          mCallBack