private void yourCurrentMethod() {

    if(spinnerinput.equals(spinnerinput2)) {
        output.setText(input.getText());
    }

    else if(spinnerinput.equals("Base 2") && spinnerinput2.equals("Base 10")) {
        String regex = "[0-1]+";
        boolean isBinary = true;
        doSomething(isBinary, "Invalid characters for a binary number!");
    }

    else if(spinnerinput.equals("Base 10") && spinnerinput2.equals("Base 2")) {
        String regex = "[0-9]+";
        boolean isBinary = false;
        doSomething(isBinary, "Invalid characters for a decimal number!");
    }
}

private void doSomething(boolean isBinary, CharSequence text){
    if(input.getText().toString().matches(regex)) {
        if(isBinary){
            output.setText(binaryToDecimal(input.getText().toString()));
        } else {
            output.setText(decimalToBinary(input.getText().toString()));
        } 
    } else {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}