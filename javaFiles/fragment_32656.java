//WebElement hoveredPortion = DriverUtils.getDriver().findElement(By.xpath("(*//div[@data-index = '" + dataIndex + "']/descendant::div//*[contains(@class, 'mli-donut-chart')]//*[contains(@transform,'translate')]//*[contains(@style,'fill-opacity: 0.3')])["+ y +"]"));

                                String notHoveredPortion = DriverUtils.getDriver().findElement(By.xpath("*//div[@data-index = '"+ dataIndex +"']/descendant::div//*[contains(@class, 'mli-donut-chart')]//*[contains(@transform,'translate')]//*[contains(@style,'fill-opacity')]")).getCssValue("fill-opacity");
                                System.out.println("value of fill-opacity: " +notHoveredPortion);

                                //if(hoveredPortion!=null) {
                                if(notHoveredPortion.equals("0.3")) {
                                    Reporter.log("Passed: allocation #: " + b, MessageTypes.Pass);
                                } else {
                                    Reporter.log("Failed", MessageTypes.Fail);
                                }