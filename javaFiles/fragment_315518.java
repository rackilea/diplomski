public List<String> fetchVehicleListAndClickOnYear(String year) {

    java.util.List<MobileElement> vehicleList =driver.findElementsById(packageName+":id/title");

    java.util.List<String> displayedYears = new ArrayList<>();
    //logic to add displayed years to list
    for (MobileElement yearEl: vehicleList) {
        displayedYears.add(yearEl.getText());
    }

    //logic to click
    for (int i=0;i< vehicleList.size();i++) {
        String actuallist = vehicleList.get(i).getText();
        System.out.println("Print vehicle year list " +actuallist);
        if(actuallist.equals(year)) {
            driver.findElementByName(year).click();
        } else {
            Utils.scrollDown(driver);
        }
    }
    return displayedYears;
}