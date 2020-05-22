public class Parent {

    protected int sum;
    protected double commission;

    protected boolean validateData() {
        return isSumWrittenCorrectly();
    }

    private boolean isSumWrittenCorrectly() {
        if (sum < 100) {
            return false;
        }
        return true;
    }

    protected void performData() {
        if(!validateData()) {
            return;
        }
        commission = sum * 0.02;
    }
}


class Child extends Parent {

    private String email;

    @Override
    protected boolean validateData() {
        if(!super.validateData()) {
            return false;
        }
        if (!isEmailWrittenCorrectly()) {
            return false;
        }
        return true;
    }

    @Override
    protected void performData() {
        super.performData();
        if(!validateData()) {
            return;
        }
        sendData(email, commission, sum);
    }
}