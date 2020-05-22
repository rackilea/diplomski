@Override
public View getView(final int position, View view, ViewGroup root)
{
    ItemHolder holder = null;

    if (view == null)
    {
        view = inflater.inflate(R.layout.list_item, root, false);
        holder = new ItemHolder();

        holder.back = (RelativeLayout) view.findViewById(R.id.bg_item);
        view.setTag(holder);
    }
    else
    {
        holder = (ItemHolder) view.getTag();
    }

    // paint oldies
    Set<String> _set = new HashSet<String>();
    _set = Prefs.getStringSet("arrOfOldies", _set);
    for(int i = 0; i <= _set.size()  ; i++)
    {
        if(_set.contains(IDs.get(position)))
        {
            holder.back.setBackgroundColor(Color.parseColor("#D0D0D0"));
        }
        else 
        {
            //add this else clause.
            holder.back.setBackgroundColor( YOUR_DEFAULT_BACKGROUND_COLOR ); 
        }
    }
}