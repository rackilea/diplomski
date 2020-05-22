int buyOrder= 0;
 if((e.getSource()==userOrder2)&& (orderType==1)){
     String buyO= userOrder2.getText();
     buyOrder= Integer.parseInt(buyO);
 }
 if(orderType==1 && (stockPrice <= buyOrder))