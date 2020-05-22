@Override
public void sendToBill(String itemName, String itemPrice) {
    count++;
    FooterBillFragment footerBillFragment = new FooterBillFragment();

    BillFragment billFragment = new BillFragment();
    billFragment.updateBill(itemName, itemPrice);

    Log.d("ItemPrice", "item price inter " + itemPrice);
    footerBillFragment.updateFooterAmount(itemPrice);
}