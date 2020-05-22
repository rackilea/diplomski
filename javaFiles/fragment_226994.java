import javax.validation.constraints.AssertTrue;


@AssertTrue
public boolean isBothFieldsValid() {
    if (quantityType.equals("foo")) {
        return quantityValue < 5;
    } else if (quantityType.equals("bar")) {
        return quantityValue < 3;
    }
    return false;
}