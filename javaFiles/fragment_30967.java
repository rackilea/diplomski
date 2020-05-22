final   Hashtable<String, String> ht = new Hashtable<String, String>(); 
ht.put("player 1", "sachin"); 
ht.put("player 2", "sehwag"); 
ht.put("player 3", "dhoni"); 
final Enumeration<String> values = ht.keys(); 

while (values.hasMoreElements()) { 
     String str = (String) values.nextElement(); 
     System.out.println(str + ":" + ht.get(str));

     RadioButton radioButtonView = new RadioButton(this);
     radioButtonView.setText(ht.get(str));
     selectedId = radioGroup.getCheckedRadioButtonId();
     radioGroup.addView(radioButtonView, p);
}