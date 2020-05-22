public class CustomListAdapter extends ArrayAdapter<CustomRowData> {

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
      CustomRowData currentRow = getItem(position);
      View customRowView = .... // such as CustomRowView below.
      ...
      ...
      return customRowView;
  }
}