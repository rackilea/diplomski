public double[] getGrossPay()
{
  if (grossPay == null) {
    grossPay = new double[NUM_EMPLOYEES]; 

    for (int count = 0; count < NUM_EMPLOYEES; count++)
    {
      grossPay[count] = getEmpPayRate()[count] * getEmpHours()[count];
    }
  }
  return grossPay;
}