int count = 40;
RadioGroup G[] = new RadioGroup[count];
for(int i = 1 ; i < count ; i++){
   String temp = "radioGroup" + i;
   int id = getResources().getIdentifier(temp, "id", getPackageName());
   G[i] = (RadioGroup) findViewById(id);
 }