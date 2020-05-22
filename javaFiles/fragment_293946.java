try 
{
if((n1 < 5000) || (n1 > 1000000))
  throw new Exception();   

  for (int i = 0; i < term[0] * 12; i++)
  {   
    double interest_paid = n1 * (rate[0] / 12);
    double principal_paid = tr1 - interest_paid;
    n1 = n1 - principal_paid;

    //Prints the results.
    edit.append("\n  " + (i+1) + " \t\t " + (two.format(interest_paid)) 
        + " \t\t " + (two.format(principal_paid)) + " \t\t "
            + (two.format(Math.abs(n1))));            
  }
}
catch (Exception e)
{        
  edit.setText("Please enter an amount between $5,000 and $1,000,000.");       
  mortText.setText("");
  out.setText("");                 
}