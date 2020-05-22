searchIATA.selectByValue("IATA");
if (searchIATA.getFirstSelectedOption().getText().trim().equals("IATA"))
 {
  System.out.println("Succesfully selected IATA.");
 }
  else
  {
      System.out.println("Selected values is not IATA, it is: "+ selected_value.getText());
  }