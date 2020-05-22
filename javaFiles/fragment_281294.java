public void getIncome(View income){
        TextView myIncomeString;
        myIncomeString = (TextView)findViewById(R.id.enterIncome);
        Double myIncome;
        myIncome = Double.parseDouble(myIncomeString.getText().toString());
    }