public void openDetailsView(String specificValue) {
    getRow(specificValue)
        .findElement(By.cssSelector("a[id$=lbView]"))
        .click();
}

public void openTestPlanView(String specificValue) {
    getRow(specificValue)
        .findElement(By.cssSelector("a[id$=hlTestPlan]"))
        .click();
}