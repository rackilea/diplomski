@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id)
{
    TextView pos = (TextView) view.findViewById(R.id.rowno);
    showsDialog(pos.getText().toString());
}