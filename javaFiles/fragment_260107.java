public void testNewCheckout(){

  try {

    driver.findElement(By.id("button-payment-address")).click();
    driver.findElement(By.id("button-shipping-address")).click();


   } catch (Exception e) {

      e.printStackTrace();           

   }

}