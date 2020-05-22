List<WebElement> seats = driver.findElements(By.cssSelector("div.GXXXXXX.GXXXXXXX"));

for (WebElement seat : seats) {
   if(seat.getAttribute("title") != null){
        System.out.println("Seat is not available");
   }else{
        System.out.println("Seat is available");
        seat.click(); // break the loop if you wish
   }                    
}