public void onClick(View v) {
    float cost1, margin1, custTP, margin2;
    float result1A = 0;
    float result2B = 0;


    if (!num1.getText().toString().isEmpty() && num1 != null){
        cost1 = Float.parseFloat(num1.getText().toString());
    } else {
        cost1 = 0f;
    }

    if (!num2.getText().toString().isEmpty() && num2 != null){
        margin1 = Float.parseFloat(num2.getText().toString());
    } else {
        margin1 = 0f;
    }

    if (!num3.getText().toString().isEmpty() && num3 != null){
        custTP = Float.parseFloat(num3.getText().toString());
    } else {
        custTP = 0f;
    }

    if (!num4.getText().toString().isEmpty() && num4 != null){
        margin2 = Float.parseFloat(num4.getText().toString());
    } else {
        margin2 = 0f;
    }


    if(v.getId()==R.id.buttoncalcprice) {
        result1A = cost1 / (1- (margin1/100));
    }

    else if (v.getId()== R.id.buttoncalculatecost) {

        result2B = custTP - ((margin2/100)*custTP);
    }

    result1.setText(result1A + "");
    result2.setText(result2B + "");
}