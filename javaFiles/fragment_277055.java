if(totalPrice >= 350) {
  int baseDiscount = 5;
  int additionalDiscount = (totalPrice - 350) / 100;
  if(additionalDiscount > 15) additionalDiscount = 15;

  return baseDiscount + additionalDiscount;
}
return 0;