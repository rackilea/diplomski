public QuotesArrayAdapter(Context context, int textViewResourceId,
                          Map<Integer,List<String>> object) {
    super(context, textViewResourceId);
    add(object);
    ...
}