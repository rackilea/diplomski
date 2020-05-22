public int CalcTotalCharges()
{
  totalCharges = (CalcStayCharges() + CalcMiscCharges());

  return totalCharges;
}