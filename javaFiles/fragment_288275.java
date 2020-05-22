public static double getTax(double income)
{
  double tax = 0.10;
  if (income > 250000.0) {
    tax = 0.35;
  } else if(income > 130000.0) {
    tax = 0.33;
  } else if(income > 60000.0) {
    tax = 0.28;
  } else if(income > 30000.0) {
    tax = 0.25;
  } else if(income > 10000.0) {
    tax = 0.15;
  }
  return tax;
}