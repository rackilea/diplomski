boolean showCheckboxes = false;

public void startSelection() {
    showCheckboxes = true;
    notifyDataSetChanged();
}

public void stopSelection() {
    showCheckboxes = false;
    notifyDataSetChanged();
}

@Override
public void onBindViewHolder(final ViewHolder holder, int position) {
    final RingtoneItem item = list.get(position);

    holder.checkBox.setVisibility(showCheckboxes ? View.VISIBLE: View.GONE);

    /*
    ...
    */
}