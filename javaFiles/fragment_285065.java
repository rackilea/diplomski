public CustomAdapter(Context context, ArrayList contact ) {
    super(context, R.layout.view_of_list, contact);
    this.mycontacts = contact;
    this.inflater = LayoutInflater.from(context);

}