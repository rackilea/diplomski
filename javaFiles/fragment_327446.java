while (breakIt) {

    breakIt = true;

    try {

        Select acao = new Select(driver.findElement(By.id("cboSubMotivo")));
        acao.selectByValue("519");

    } catch (Exception e) {

        if (e.getMessage().contains("element is not attached")) {

            breakIt = false;
        }
    }
}