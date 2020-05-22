final LinearLayout ll = new LinearLayout(this);
ll.setOrientation(LinearLayout.VERTICAL);

final LinearLayout ll2 = new LinearLayout(this);
ll2.setOrientation(LinearLayout.HORIZONTAL);

for(int i = 0; i < 20; i++) {
    CheckBox cb = new CheckBox(getApplicationContext());
    TextView txt = new TextView(getApplicationContext());
    txt.setText("test!");
    ll2.addView(cb);
    ll2.addView(txt);
}

ll.addView(ll2);
sc.addView(ll);