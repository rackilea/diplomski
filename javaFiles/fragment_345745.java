<body>
  <button id="myBtn" class="" onmouseover="this.class = \"hovered\";" />
</body>

// pseudo-code
1. WebElement button = driver.findElement(By.id("myBtn")); // right now, if you read the Class, it will return ""
2. button.hoverOver(); // now the class will be "hovered"
3. wait.until(ExpectedConditions.refreshed(button));
4. button = driver.findElement(By.id("myBtn")); // by this point, the DOM manipulation should have finished since we used refreshed.
5. button.getClass();  // will now == "hovered"