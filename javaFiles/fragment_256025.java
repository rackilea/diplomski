private String sValue;
@Override
public void actionPerformed(ActionEvent evt)
{
  if (evt.getSource() == severityBox )
  {
     sValue = (String)severityBox.getSelectedItem();
     if ( "Major".equals(sValue))
     {
        sValue = "Red";
     }
    System.out.println(sValue);
  }
}