public ListAdapter(Context context, Listener listener, List<UserData> dataList1) {
     this.context = context;
     this.dataList = dataList1;
     this.listener = listener;
     inflater = LayoutInflater.from(context);
 }