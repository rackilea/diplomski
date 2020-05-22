public class Parent {

    protected int sum;
    protected double commission;

    protected void validateData() {
        if(!isSumWrittenCorrectly()) {
            throw new IllegalArgumentException("sum is not correct");
        }
    }

    private boolean isSumWrittenCorrectly() {
        if (sum < 100) {
            return false;
        }
        return true;
    }


    protected boolean performData() {
        validateData();
        commission = sum * 0.02;
    }
}


class Child extends Parent {

    private String email;

    @Override
    protected boolean validateData() {
        super.validateData();
        if (!isEmailWrittenCorrectly()) {
            throw new IllegalArgumentException("email is not correct")
        }
    }

    @Override
    protected void performData() {
        validateData();
        super.performData();
        sendData(email, commission, sum);
    }
}