@BindingAdapter({"inflateData"})
public static void inflateData(LinearLayout layout, Map<String, Double> data) {
    LayoutInflater inflater = LayoutInflater.from(layout.getContext());
    for (Entry<String, Double> entry : data.entrySet()) {
        MyItem myItem = inflater.inflate(R.layout.my_item, layout, true);
        myItem.setKey(entry.getKey);
        myItem.setValue(entry.getValue);
    }
}