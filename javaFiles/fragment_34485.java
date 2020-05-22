@Test
public void Verify_a_Specific_Inquiry() throws Exception {


    // Loc.NavXPath(Our_Stock);

    List<String> TruckList = new ArrayList<String>();
    List<String> TruckListHref=new ArrayList<String>();
    List<WebElement> Truck_List_Element = driver.findElements(By.xpath("//div[@class='Stock-trucksList ng-tns-c11-6 isCards ng-star-inserted']"));

    for (WebElement x : Truck_List_Element) {

        // System.out.println(x.getText());

        // findElements(By.className("Truck ng-star-inserted"));

        // List<WebElement> in= driver.findElements(By.xpath("//body//volvo-truck[2]"));
        // //GET ONE TRUCK

        List<WebElement> in = driver.findElements(By.tagName("volvo-truck"));

        for (WebElement z : in) {

            // System.out.println(z.getText());

            TruckList.add(z.getText());

            //System.out.print(z.getClass("Truck ng-star-inserted").)

            TruckListHref.add(z.findElement(By.tagName("a")).getAttribute("href"));

            //System.out.print(z.findElement(By.tagName("a")).getAttribute("href"));

        }

    }

    String FirstTruck = TruckList.get(0);
    String FirstHref = TruckListHref.get(0);

    System.out.println(FirstTruck);
    System.out.println(FirstHref);

    driver.quit();

}