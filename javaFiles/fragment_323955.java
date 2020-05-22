public static final int ACTION_1 = 1;
public static final int ACTION_2 = 2;
public static final int ACTION_NULL = -1;
public static final String ID_ACTION = "action_id";

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    int id = getIntent().getIntExtra(ID_ACTION, -1);

    if (id == ACTION_NULL) {
        Log.d("TAG", "id is null");
        Toast.makeText(MainActivity.this, "id is null!", Toast.LENGTH_SHORT).show();
    } else if (id == ACTION_1) {
        Log.i("TAG", "ALLOHA! from button 1");
         Toast.makeText(MainActivity.this, "Aloha from button 1!", Toast.LENGTH_LONG).show();
    } else if (id == ACTION_2) {
        Log.i("TAG", "Hello from button 2");
         Toast.makeText(MainActivity.thi,"Hello from button 2!", Toast.LENGTH_LONG).show();
    }
}