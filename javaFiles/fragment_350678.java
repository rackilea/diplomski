@BindingAdapter({"android:entries"})
public static void setEntries(AbsSpinner view, List<String> entries) {
    if (entries != null) {
        SpinnerAdapter oldAdapter = view.getAdapter();
        boolean changed = true;
        if (oldAdapter != null && oldAdapter.getCount() == entries.size()) {
            changed = false;
            for (int i = 0; i < entries.size(); i++) {
                if (!entries.get(i).equals(oldAdapter.getItem(i))) {
                    changed = true;
                    break;
                }
            }
        }
        if (changed) {
            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(view.getContext(),
                            android.R.layout.simple_spinner_item,
                            entries.toArray(new String[entries.size()]);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            view.setAdapter(adapter);
        }
    } else {
        view.setAdapter(null);
    }
}