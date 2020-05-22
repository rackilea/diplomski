public customList(Activity activity, List<itemsModel> itemsList) {
    this.activity = activity;
    this.itemsList = itemsList;
    inflater = activity.getLayoutInflater();
    customFontBold = Typeface.createFromAsset(activity.getApplication().getAssets(), "fonts/Assistant-Bold.ttf");
}