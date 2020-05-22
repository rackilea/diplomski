@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View listItemView = convertView;
    Holder holder = null;
    if (listItemView == null) {
        listItemView = LayoutInflater.from(getContext()).inflate(
                R.layout.for_each_watch_all, parent, false);
        holder = new Holder();

        holder.ckbox =(CheckBox)row.findViewById(R.id.check_box_id);

        listItemView .setTag(holder);
    }else {

        holder = (Holder) listItemView.getTag();
        holder.ckbox.setOnCheckedChangeListener(null);

    }
    final Subject currSubject = getItem(position);

    final CheckBox cb = (CheckBox) listItemView.findViewById(R.id.checkbox_for_each);
    cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
            if (isChecked){
                currSubject.setChosen(true);
            }
            else{
                cb.setChecked(false);
                currSubject.setChosen(false);
            }
        }
    });

    return listItemView;
}

private class ViewHolder {
    CheckBox checkBox;
}