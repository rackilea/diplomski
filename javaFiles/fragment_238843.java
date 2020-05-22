try {
            WebElement e = driver.findElement(By.id("//id of undo-checkout"));
            undocheckout();
            }catch (Exception e) {
            WebElement e1 = driver.findElement(By.id("//id of checkout-and-edit""));
            checkoutandedit();
            }