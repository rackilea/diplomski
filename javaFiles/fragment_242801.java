protected void popUpCalculator(){
   final Dialog dialog_cal = new Dialog(NewExpence.this);
   dialog_cal.setTitle("Calculator");
   dialog_cal.setContentView(R.layout.calculater);

   int buttonIds[] = { R.id.btn0 , R.id.btn1, R.id.btn2, R.id.btn3,
                       R.id.btn4 , R.id.btn5, R.id.btn6, R.id.btn6,
                       R.id.btn7 , R.id.btn8, R.id.btn9, R.id.btnC,
                       R.id.btnDot , R.id.btnDiv, R.id.btnMulti, 
                       R.id.btnMinus , R.id.BtnAdd , R.id.Value }

   for(int i=0; i<buttonIds.length; i++){
        dialog_cal.findViewById(buttonIds[i]).setOnClickListener(this);
       // use this if you are implementing View.OnClickListener
   }

   dialog_cal.show();
}

@Override
public void onClick(View v) {
   if(v.getId() == R.id.calButton){
      popUpCalculator();
   }
   // for other buttons chech their ids and write the respective code
}