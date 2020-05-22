public void clickSubmit() {
  click(By.className("submitButton"));

  if (driver.getCurrentUrl().contains("mysterypage")) {
      MysteryPage mysteryPage = new MysteryPage(driver);
      mysteryPage.completeForm();
      mysteryPage.clickSumbit();
  }
}