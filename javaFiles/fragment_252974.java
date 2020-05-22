int totalPrice = 0;
for(int i=carList.size(); i>0; i--)
{
  totalPrice += carList.getNext().getPrice();
}
return totalPrice;