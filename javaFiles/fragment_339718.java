private void init(Context context, int resource, int textViewResourceId, List<T> objects) {
    mContext = context;
    // line 310 below
    mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    mResource = mDropDownResource = resource;
    mObjects = objects;
    mFieldId = textViewResourceId;
}