public void setResultLabel(double inNumber, char inChar)
{   

    String number, letter;
    DecimalFormat decimalFormat = new DecimalFormat("##.##"+inChar);


    String formated = decimalFormat.format(inNumber); 
    /* formated  is your result  */
    // System.out.println(formated);

    result.setText(format);
    add(result);
}