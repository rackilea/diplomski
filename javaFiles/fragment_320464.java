public void checkQOR() {
    int rowCount = driver.findElements(By.xpath("//*[@id=\"po-carts\"]/div[1]/div/table/tbody/tr")).size();
    for (int j = 1; j <= rowCount; j++) {
        for (int i = 1; i < 100; i++) {
        WebElement elementMIN = driver.findElement(By.xpath("//*[@id=\"po-carts\"]/div[1]/div/table/tbody/tr[" + j + "]/td[3]"));
        wait.until(ExpectedConditions.visibilityOf(elementMIN));
        double doubleMIN = Double.parseDouble(elementMIN.getText().replaceAll("-", "0"));
        WebElement elementCUR = driver.findElement(By.xpath("//*[@id=\"po-carts\"]/div[1]/div/table/tbody/tr[" + j + "]/td[4]"));
        wait.until(ExpectedConditions.visibilityOf(elementCUR));
        double doubleCUR = Double.parseDouble(elementCUR.getText().replaceAll("-", "0"));
        WebElement elementMAX = driver.findElement(By.xpath("//*[@id=\"po-carts\"]/div[1]/div/table/tbody/tr[" + j + "]/td[5]"));
        wait.until(ExpectedConditions.visibilityOf(elementMAX));
        double doubleMAX = Double.parseDouble(elementMAX.getText().replaceAll("-", "0"));
            if ( doubleMIN > 0 && doubleCUR < doubleMIN && (doubleCUR < doubleMAX || doubleMAX==0 )) {
                Integer number = firstnumber + i;
                String stringNumber = number.toString();
                wait.until(ExpectedConditions.visibilityOf(increaseProduct1));
                increaseProduct1.clear();
                increaseProduct1.sendKeys(stringNumber);}
                else if (doubleMAX > 0 && doubleCUR > doubleMAX) {
                    //DO SMTH
                }
                else {
                    break;
            }
            }

        }
    }