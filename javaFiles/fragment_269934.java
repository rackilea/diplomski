public class AutoCompleteAdapter extends ArrayAdapter<RMAutoComplete.ListItem> 
{


private CustomFilter _customFilter = null;

@Override
public Filter getFilter() {

    if (_customFilter == null)
        _customFilter = new CustomFilter();
    return _customFilter;
}


public AutoCompleteAdapter(Context context, int textViewResourceId) {
    super(context, textViewResourceId);

}

}