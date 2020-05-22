List<String> list = new ArrayList<String>();
for(MyEnum me: MyEnum.values()){
    list.add(me.getMyName());
 }

 ComboBoxItem cbi = new ComboBoxItem();
 cbi.setValueMap(list.toArray(new String[list.size()]));