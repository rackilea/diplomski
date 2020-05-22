@AssertTrue(message = "quantity should be below 5 for foo")
public boolean isQuantityValidForFoo() {
    if (quantityType.equals("foo")) {
        return quantityValue < 5;
    }
    return true;
}

@AssertTrue(message = "quantity should be below 3 for bar")
public boolean isQuantityValidForBar() {
    if (quantityType.equals("bar")) {
        return quantityValue < 3;
    }
    return true;
}