String valDesejado = tipopromocao;
boolean variavelVerificadora1 = false; // use boolean instead of int set to 0/1
Select verificaOpt = new Select(driver.findElement(By.name("tipoDePromocaoPromocao")));
System.out.println("Tamanho: " + verificaOpt.getOptions().size());
// as this loops, the variable 'option' contains the current loops' OPTION element
// you don't need to select the option to get its text so this loop should be much faster
// it selects the OPTION once the correct one is found
for (WebElement option : verificaOpt.getOptions())
{
    if (valDesejado.equalsIgnoreCase(option.getText()))
    {
        verificaOpt.selectByVisibleText(option.getText()); // select the OPTION match
        variavelVerificadora1 = true; // set the boolean to true to indicate we found a match
        break; // exits the for loop
    }
}

if (!variavelVerificadora1) // this is the equivalent of variavelVerificadora1 == false, it's basically saying if not true
{
    System.out.println("ALERTA: The Option" + valDesejado + " no comboBox \"tipoDePromocaoPromocao\" not found.");
}