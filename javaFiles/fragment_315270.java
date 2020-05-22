found = false;

while(found == false){

   attemptFind = $driver.findElements({xpath: "//h3[contains(text(),'eBay: Electronics')]"}); // Returns an array of headers are found with Ebay.co.uk in

   if attemptFind.length() == 0 || attemptFind == null {
      currentPage = $driver.findElement({css: "td.cur"}).getText(); // Get Current Page Number
      nextPage = (currentPage.toInt() + 1).toString(); // Add 1 to current page

      $driver.findElement({css: "a[aria-label='Page "+nextPage+"']"}).click(); // Go to next page
   } else {
      attemptFind[0].click(); // Click on the Ebay link
      found = true; // Break out of loop
   }
}