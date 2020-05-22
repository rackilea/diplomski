public class DynamicTableRowWithCheckBox extends Activity
{
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    final Button notifySubmitButton = (Button) findViewById(R.id.myButton);
    TableLayout table = (TableLayout) findViewById(R.id.myTable);

    for (int i = 0; i < 3; i++)
    {
      TableRow row = new TableRow(this);
      CheckBox chk = new CheckBox(this);
      chk.setText(Integer.toString(i));
      row.addView(chk);
      table.addView(row);
    }

    notifySubmitButton.setOnClickListener(
        new View.OnClickListener()
        {
          @Override
          public void onClick(View v)
          {
            finish();
          }
        });
  }
}