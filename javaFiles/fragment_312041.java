calculateButton.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View arg0) {


        if(validationET())
        {

             final AlertDialog.Builder alert = new AlertDialog.Builder(context); 
                LayoutInflater factory = LayoutInflater.from(context);        
                final View textEntryView = factory.inflate(R.layout.dialog,null);
            resultOne=(TextView)textEntryView.findViewById(R.id.resultOne); //resultone is a textview in xml dialog
            resultTwo=(TextView)textEntryView.findViewById(R.id.resultTwo);
            alert.setTitle("RESULT");
            alert.setIcon(R.drawable.ic_launcher);
            alert.setView(textEntryView);


            alert.setNeutralButton("OK",null);




        getETvalue();
        evaluation();
        CalcUpliftTV.setText(String.valueOf(CalUpliftResult));
        DiscrepancyTV.setText(String.valueOf(DiscResult));
        resultOne.setText("Calc. Uplift (KG)= "+String.valueOf(CalUpliftResult));
        resultTwo.setText("Discrepancy(%)= "+String.valueOf(DiscResult));
        AlertDialog alertD = alert.create();
        alertD.show();






        }
        else
            Toast.makeText(getApplicationContext(), "please give all inputs", Toast.LENGTH_SHORT).show();

    }


});