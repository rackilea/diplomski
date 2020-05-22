public void afterTextChanged(Editable s) 
{               
  if(s.length() == 0 || s.toString().equals("+"))
  {
    numberText.settext("+1");
  }
  else if(s.length() == 1)
  {
    numberText.settext("+1"+s.toString());
    numberText.setSelection(numberText.getText().length());
  }
}