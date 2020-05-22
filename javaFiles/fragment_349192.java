View view1 = createFirstView();
CheckBox a = (CheckBox)view1.findViewById(R.id.checkBox1);
CheckBox b = (CheckBox)view1.findViewById(R.id.checkBox2);
HashMap<Integer, CheckBox> view1Map = new HashMap<Integer, CheckBox>();
view1Map.put(1, a);
view1Map.put(2, b);
mainMap.put(view1, view1Map);
// rinse and repeat for every instantiated view, changing the variables each time - ie, view2/view2Map, etc.