String xPath = "//*[@id='mainForm']/div/div[3]/div/div/table/tbody/tr[1]/td[6]";
                String text = driver.findElement(By.xpath(xPath)).getText();
                text  = text.replace("%", "");
                double percentage = Double.parseDouble(text);   

                Assert.assertTrue(percentage > 130.67 && percentage < 135.69);