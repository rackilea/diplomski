@Then("The user clicks add to basket button")
public void theUserClicksAddToBasketButton() {
    try {
        if (Hooks.isIos()) {
            iosHomePage.clickAddToBasket();
        } else {
            androidHomePage.clickAddToBasket();
        }
        logger.info("The user clicked add to basket button");
    } catch (Throwable err) {
        logger.fatal("The user can not clicks add to basket button");
        Assert.fail("ERROR : " + "The user can not clicks add to basket button" + err);
    }
}