if (numberString.isEmpty()){
    Toast.makeText(getApplicationContext(), "Enter a Number!", Toast.LENGTH_LONG).show();
}else{
    try {
        int numberText = Integer.parseInt(numberString);
        // the rest of your code
    } catch (NumberFormatException e) {
        Log.e(getClass.getSimpleName(), e);
        Toast.makeText(getApplicationContext(), "Enter a Number!", Toast.LENGTH_LONG).show();
    } 
}