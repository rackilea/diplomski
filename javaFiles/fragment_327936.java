public AirlinesListAdapter(Activity activity, List<Airlines> favorites) {
    super(activity, R.layout.list_item, favorites);
    this.activity = activity;
    if(favorites == null)
        favorites = new ArrayList<>();
   else 
        this.favorites = favorites;
    sharedPreference = new SharedPreference();

}