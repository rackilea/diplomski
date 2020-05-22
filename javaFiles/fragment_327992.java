private WebDriver driver;

public ConsultaClientePorDocumento(WebDriver d){
    this.driver = d;
    this.cancelarButton = driver.findElement(By.id("Cancelar"));
}

public WebElement cancelarButton;