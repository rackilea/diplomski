List<WebElement> spans = driver.findElements(By.cssSelector(".x106"));
WebElement menuCadCliente;
for (WebElement span : spans) {
  if (span.getText().equals("Cadastro de cliente")) {
    menuCadCliente = span;
  }
}