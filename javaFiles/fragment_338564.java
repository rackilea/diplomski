public static void percentageChecked(){
Vector<CheckBox> allBoxes=new Vector<CheckBox>();
CheckBox cb1,cb2, cb3;...//declare all 39 checkboxes
int counterChecked=0;

cb1=(CheckBox)findViewById(R.id.checkBox1);
cb2=(CheckBox)findViewById(R.id.checkBox2);//initialize each checkbox from the layout
...
allBoxes.add(cb1);//add each checkbox to vector
...

//iterate through all checkboxes:

for(int i=0; i<allBoxes.size();i++)
   if(allBoxes.get(i).isChecked()){
   counterChecked++;
   }
}

float percent = (counterChecked * 100.0f) / allBoxes.size();
craftedPercent.setText(percent);
}