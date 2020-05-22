try {
            Date varDate = dateFormat.parse("01-Sep-2017");
            dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 2017-08-18
            finalSnapshot1 = dateFormat.format(varDate).toString();
            System.out.println("Date: " + finalSnapshot1); // Prints 2017-08-18
            driver.findElement(By.xpath(config.getsnapshotFilter())).click();
            Thread.sleep(2000);

            stageListOfFilters = driver
                    .findElements(By.xpath("(//*[@class='QvFrame DS'])[1]/div/div/div[1]/child::div")); // This collects
                                                                                                        // the list
            // of dates which is
            // fetched later on in
            // for loop
            System.out.println("Size" + stageListOfFilters.size());
            Thread.sleep(2000);
            for (int i = 1; i < stageListOfFilters.size(); i++) {

                if (finalSnapshot1.equals(stageListOfFilters.get(i).getText())) {
                    System.out.println("Filters list value: " + stageListOfFilters.get(i).getText());
                    System.out.println("Value to be compared: " + finalSnapshot1);
                    i = i + 1;
                    driver.findElement(By.xpath(".//*[@class='QvFrame DS']/div/div/div[1]/div[" + i + "]/div[1]"))
                            .click();
                    System.out.println("Value of i: " + i +" and Date is: "+ finalSnapshot1.toString());
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }