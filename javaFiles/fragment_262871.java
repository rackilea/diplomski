class Customer {

      public void iWannaEat() {

         DinnerNowSystem dns =new DinnerNowSystem();              
         Restaurant r = new Restaurant();
         Bank b = new Bank();

         while (...) dns.addOrderItem();
         dns.confirmOrder();
         dns.sendorder();
         dns.paymentDetail();
         Food f = r.receiveFood();
       }
      }

    class DinnerNowSystem() {
        Bank b;
        Restaurant r; 
        void addOrderItem();
        void confirmOrder() {
         r.sendOrder();
        }
        void paymentDetail() {
         if (b.processPayment())
            r.confirmOrder() 
            else halt and catch fire; 
        }
    }