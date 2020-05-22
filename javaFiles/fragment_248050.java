String actualPrice = null;
@And("^verify the \"([^\"]*)\"$")
public void gettxt(String actualPricePath) throws Throwable {
            actualPrice= driver.findElement(By.xpath(actualpricePath)).getText();
}

@And("^Compare to the \"([^\"]*)\"$")
public void comparePrices(String expectedPrice){
    Assert.assertEquals(expectedPrice, actualPrice, "The actual price is not equal to expected price");
}