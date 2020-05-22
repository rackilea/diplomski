EditText startnumtext= (EditText)findViewById(R.id.yourstartedittextid);
EditText endnumtext= (EditText)findViewById(R.id.yourendedittextid);

int startnumber=Integer.parseInt(startnumtext.getText().toString());// can throw a NumberFormatException if you put anything but digits inside the edittext

int endnumber=Integer.parseInt(endnumtext.getText().toString());// can throw a NumberFormatException if you put anything but digits inside the edittext

for(int x=startnumber;x<=endnumber;x++){   
    if(x%3==0){
       Log.d("MyActivity","H");
    }else if(x%5==0){
       Log.d("MyActivity","S");
    }else{
       Log.d("MyActivity",String.valueOf(x));
    }

}