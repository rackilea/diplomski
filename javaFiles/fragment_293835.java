public class MainActivity extends AppCompatActivity {

LinearLayout ll_dynamic;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ll_dynamic=(LinearLayout)findViewById(R.id.hhh);
    final String name[] = {"Credit Card", "Debit Card","Bank Deposit","in-app Purchase", "PayPal"};
    /*int Array_Count=0;
    String[] Str_Array = new String[0];

    Array_Count = Str_Array.length;*/

    for (int i = 0; i < name.length; i++)
    {

        final View v = new View(this);
        v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 5));

        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.VERTICAL);
        row.setId(i);
        row.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        final CheckBox checkBox = new CheckBox(this);
        checkBox.setId(1000+i);
        checkBox.setText(name[i]);
        checkBox.setPadding(20,60,0,60);
        checkBox.setTextSize(20);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(60, 0, 0, 0);
        checkBox.setLayoutParams(params);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    for (int j = 0; j < name.length; j++) {
                        if (buttonView.getId() != 1000+j) {
                            CheckBox chk = (CheckBox)ll_dynamic.findViewById(1000+j);
                            chk.setChecked(false);
                        }
                    }
                }
            }
        });
        row.addView(checkBox);

        row.addView(v);
        ll_dynamic.addView(row);
    }
}