public static void main(String[] args) {

   // first you need to store your testdata in a collection 

    Map<String,String> pinCodes = new HashMap<String, String>();
    pinCodes.put("pin1", "2");
    pinCodes.put("pin2", "3");
    pinCodes.put("pin3", "3");
    pinCodes.put("pin4", "4");

    // you can remove the values as per you need suppose you only want `pin1` `pin2` then remove  `pinCodes.put("pin3", "3");` and `pinCodes.put("pin4", "4");` from above code

      enterPinCode(pincodes); //call method to enter the values in corresponding text-boxes 
}

public void enterPinCode(Map<String,String> pinCodes) {

        for (Entry<String, String> entry : pinCodes.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            switch (key) {
                case "pin1" :
                    driver.findElement(By.cssSelector("div[class='field-set'] input.input-pin:nth-child(1)")).sendKeys(value);
                    break;
                case "pin2" :
                    driver.findElement(By.cssSelector("div[class='field-set'] input.input-pin:nth-child(2)")).sendKeys(value);
                    break;
                case "pin3" :
                    driver.findElement(By.cssSelector("div[class='field-set'] input.input-pin:nth-child(3)")).sendKeys(value);
                    break;
                case "pin4" :
                    driver.findElement(By.cssSelector("div[class='field-set'] input.input-pin:nth-child(4)")).sendKeys(value);
                    break;

                default :
                    System.out.println("pincode textbox key not found");
                    break;
            }

        }
}