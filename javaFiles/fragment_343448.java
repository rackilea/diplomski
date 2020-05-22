List<WebElement> rows = new WebDriverWait(driver, 10)
        .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".tablepress tbody tr[role=row]")));

// By whole phrase
List<WebElement> physicsAndAstronomy1 = rows.stream().filter(e ->
        e.findElement(By.cssSelector("td:nth-child(2)")).getText().toLowerCase()
                .contains("physics and astronomy"))
        .collect(Collectors.toList());

// By separately words
List<WebElement> physicsAndAstronomy2 = rows.stream().filter(e -> {
    String text = e.findElement(By.cssSelector("td:nth-child(2)")).getText().toLowerCase();
    return text.contains("physics") && text.contains("astronomy");
}).collect(Collectors.toList());