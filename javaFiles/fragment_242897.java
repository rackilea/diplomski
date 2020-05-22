// In onListItemClick
if (displayed.get(position).equals(answer[position])) {
    displayed.set(position, capital[position]);
} else {
    displayed.set(position, answer[position]);
}
((ArrayAdapter) getListAdapter()).notifyDataSetChanged();