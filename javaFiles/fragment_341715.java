// get the page source and remove all spaces
String pageSource = driver.getPageSource().replace(" ", "");

// split the page source into 2 based on the text and use the second
// part. This will give the required text plus the additional HTML
pageSource = pageSource.split("<span>The users new password is: </span>".replace(" ", ""))[1];

// split again using the <br/> to get the required text
pageSource = pageSource.split("<br/>")[0];

System.out.println(pageSource.trim());