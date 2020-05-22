public class LgasAutoCompleteAdapter extends BaseAdapter implements Filterable {

private static final String TAG = "LgasAutoComp";
private Context mContext;
private List<Lga> mResult = new ArrayList<>();
private LayoutInflater inflater;

public LgasAutoCompleteAdapter(Context mContext) {
    this.mContext = mContext;
}

@Override
public int getCount() {
    return mResult.size();
}

@Override
public Object getItem(int position) {
    return mResult.get(position);
}

@Override
public long getItemId(int position) {
    return position;
}

@Override
public View getView(int position, View view, ViewGroup parent) {
    if (inflater == null)
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    if (view == null)
        view = inflater.inflate(R.layout.item_baker_autocomplete, parent, false);

    Lga lga = mResult.get(position);

    TextView customerNameLabel = (TextView) view.findViewById(R.id.bakerName);
    TextView bakerAddress = (TextView) view.findViewById(R.id.bakerAddress);

    if (lga != null) {
        if (customerNameLabel != null) {
//              Log.i(MY_DEBUG_TAG, "getView Customer Name:"+customer.getName());
            customerNameLabel.setText(lga.getName());
            bakerAddress.setVisibility(View.GONE);
        }
    }

    return view;
}

@Override
public Filter getFilter() {
    return new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            return null;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults filterResults) {
            if (constraint != null) {
                //String query = constraint.toString().toLowerCase();
                mResult = filterStates(constraint.toString());
                Log.e(TAG, ""+mResult.size());
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }
    };
}

@NonNull
private List<Lga> filterStates(String query) {
    Realm mRealm = RealmUtils.getRealmInstance(mContext);
    return mRealm.where(Lga.class)
            .contains("name", query)
            .or()
            .beginsWith("name", query)
            .findAll();
}
}