public void testEmptyPriceIncrease() {
    PriceIncreaseValidator priceIncreaseValidator = new PriceIncreaseValidator();
    PriceIncrease priceIncrease = new PriceIncrease();
    Errors errors = new BeanPropertyBindingResult(priceIncrease, "priceIncrease");

    priceIncreaseValidator.validate(priceIncrease, errors); // This is where I get NPE

    assertTrue(errors.hasErrors());
}