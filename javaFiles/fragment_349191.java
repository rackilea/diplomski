HashMap<Integer, CheckBox> map = new HashMap<Integer, CheckBox>();
map.put(1, (CheckBox)findViewById(R.id.checkBox1));
map.put(2, (CheckBox)findViewById(R.id.checkBox2));
...
CheckBox a = map.get(1);
CheckBox b = map.get(2);