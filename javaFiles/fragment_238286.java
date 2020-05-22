public void yourExternalMethod(Activity activity) {
   Intent intent = new Intent(activity, SignupActivity.class);
   activity.startActivity(intent);
   AnimatorClass.appearLeftAnimation(activity);
   activity.finish();
}