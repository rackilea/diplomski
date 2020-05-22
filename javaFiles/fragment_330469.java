private Context primaryBaseActivity;//THIS WILL KEEP ORIGINAL INSTANCE

@Override
protected void attachBaseContext(Context newBase) {
    primaryBaseActivity=newBase;//SAVE ORIGINAL INSTANCE

    /*Some locale handling stuff right here*/
    /*LocaleHelper's onAttach is returning a *new* context in Android N which will void PrintManager's context*/
    super.attachBaseContext(LocaleHelper.onAttach(newBase,appLocale));

}