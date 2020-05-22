final CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
final CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
final CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
final CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
final CheckBox cb5 = (CheckBox) findViewById(R.id.checkBox5);
cb1.setOnCheckedChangeListener(new CheckBoxListener());
cb2.setOnCheckedChangeListener(new CheckBoxListener());
cb3.setOnCheckedChangeListener(new CheckBoxListener());
cb4.setOnCheckedChangeListener(new CheckBoxListener());