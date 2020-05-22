class Main{
  public static void main(String[] a){
    String lblTextVal = "0.00";
    String inputText = "";
    System.out.println("Starting with: lblTextVal: "+lblTextVal + " inputText: \""+inputText+"\"");
    System.out.println();

    java.text.NumberFormat decimalFormat = new java.text.DecimalFormat("#,##0.00");

    for(String btnPress : new String[]{"1","2","3","4","0","0","3"}){
      inputText += btnPress;                    // inputTxt.append(btnTxtVal);
      Double temp = Double.parseDouble(inputText.toString()) / 100;
      lblTextVal = decimalFormat.format(temp);  // lblInput.setText(decimalFormat.format(temp));

      System.out.println("pressedBtn: "+btnPress+" temp: "+temp);
      System.out.println("formattedTemp: "+decimalFormat.format(temp));
      System.out.println();
    }
  }
}