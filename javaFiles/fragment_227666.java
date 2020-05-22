EditText Tfood1amount = (EditText) findViewById(R.id.TFood1Amount);
EditText Tfood2amount = (EditText) findViewById(R.id.TFood2Amount);
ListView lvlast = (ListView) findViewById(R.id.LVfinal);
final ArrayList<String> OrderList = new ArrayList<String>();
final ArrayAdapter<String> adapter;
int food1amount = 0;
int food2amount = 0;
food1amount = Integer.parseInt(String.valueOf(Tfood1amount.getText()));
food2amount = Integer.parseInt(String.valueOf(Tfood2amount.getText()));