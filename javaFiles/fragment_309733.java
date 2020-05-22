public function getOrder() {
  //instantiate variables

  orderNumber = userInput.nextInt();
  while (orderNumber != 0) {
    switch(orderNumber){
      case 1:
        totalBill = totalBill + American;
        break;
      case 2:
        totalBill = totalBill + Expresso;
        break;
      case 3:
        totalBill = totalBill + Latte;
        break;
      default:
        //Error handling is important!
        break;
     }
     displayMenu();
     orderNumber = userInput.nextInt();
  }
  System.out.println("Your total bill will be $"+ totalBill);
}