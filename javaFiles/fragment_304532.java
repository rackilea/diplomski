try
{
numberOfDecks = Integer.parseInt(numberField.getText().toString());
}catch(NumberFormatException e)
{
  e.printStackTrace();
}