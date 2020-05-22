public static Intent getIntent(Context context, Bundle bundle) {
Intent intent = new Intent(context, MainActivity.class);
if (bundle != null) {
  intent.putExtras(bundle);
}
return intent;
}