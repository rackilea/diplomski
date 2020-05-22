public class CustomAutocompletAdapter extends BaseAdapter implements Filterable {

private String stationNameAndCodeValue;
ArrayList<String> autolistArray;
ArrayList<String> objects;
private Context context;

public CustomAutocompletAdapter(Context context, String[] autolistArray) {
    this.autolistArray = new ArrayList<String>();
    for (int i = 0; i < autolistArray.length; i++) {
        this.autolistArray.add(autolistArray[i]);

    }
    this.context = context;
}

@Override
public int getCount() {
    return autolistArray.size();
}

@Override
public Object getItem(int position) {
    return autolistArray.get(position);
}

@Override
public long getItemId(int position) {
    return position;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View v = convertView;
    if (v == null) {
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = mInflater.inflate(R.layout.custom_row_adapter, null);
    }

    final TextView stationNameAndCode = (TextView) v
            .findViewById(R.id.item_selectStationName);

    stationNameAndCodeValue = autolistArray.get(position);

    stationNameAndCode.setText(stationNameAndCodeValue);

    return v;
}

Filter myFilter = new Filter() {

    @SuppressWarnings("unchecked")
    @Override
    protected void publishResults(CharSequence constraint,
            FilterResults results) {

        System.out.println("Constraint " + constraint);
        Log.d("-----------", "publishResults");
        if (results.count > 0 && results != null) {
            autolistArray = (ArrayList<String>) results.values;
            notifyDataSetChanged();
        } else {
            notifyDataSetInvalidated();
        }

    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        Log.d("-----------", "performFiltering");
        FilterResults results = new FilterResults();
        List<String> filteredArrList = new ArrayList<String>();
        if (objects == null) {
            objects = new ArrayList<String>(autolistArray);
        }
        Locale locale = Locale.getDefault();
        if (constraint == null || constraint.length() == 0) {
            // set the Original result to return
            results.count = objects.size();
            results.values = objects;

        } else {
            constraint = (String) constraint.toString().toLowerCase(locale);
            Pattern logEntry = Pattern.compile("-\\((.*?)\\)");
            for (int i = 0; i < objects.size(); i++) {
                String name = objects.get(i);
                // System.out.println(name);

                Matcher matchPattern = logEntry.matcher(name);
                String subText = "";
                while (matchPattern.find()) {
                    subText = matchPattern.group(1);
                }
                if (subText.toLowerCase(locale).contains(constraint)) {
                    filteredArrList.add(name);
                }
            }
            System.out.println(filteredArrList);
            // set the Filtered result to return
            results.count = filteredArrList.size();
            results.values = filteredArrList;

        }
        return results;
    }

};

@Override
public Filter getFilter() {
    return myFilter;
}
}