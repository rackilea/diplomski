btnSearch.setOnClickListener(new OnClickListener() { 

@Override 
public void onClick(View v) { 
// TODO Auto-generated method stub 

Integer objMin = new Integer(editMin.getText().toString()); 
Log.d("min:", String.valueOf(objMin)); 
Integer objMax = new Integer(editMax.getText().toString()); 
Log.d("max:", String.valueOf(objMax)); 

ArrayList<Home> temp_arraylist = new ArrayList<Home>(); 

for (int i = 0; i < arrayList.size(); i++) { 

int price = (Integer.parseInt(arrayList.get(i).getPrice().replace(",", ""))); 

if(price >= objMin && price <= objMax){ 
temp_arraylist.add(arrayList.get(i)); 
} 

} 

adapter = new HomeAdapter(getApplicationContext(), R.layout.adapter_home, temp_arraylist); 
listview.setAdapter(adapter); 

} 
});