class ParallelDataObject {

    private final ThreadLocal<HelperClass> helperClassThreadLocal = new ThreadLocal<HelperClass>() {

        @Override
        protected HelperClass initialValue() {
            return new HelperClass(new Data());
        }
    };

    private HelperClass helperClass() {
        return helperClassThreadLocal.get();
    }

    @Test
    public void passM1() {
        helperClass().verifyFlag();
    }

    @Test
    public void failM2() {
        helperClass().getData().setFlag(false);
        helperClass().verifyFlag();
    }

}

class HelperClass {

    private final Data data;

    public HelperClass(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void verifyFlag() {
        assert data.getFlag();
    }
}

class Data {
    private boolean flag = true;

    public Data setFlag(boolean flag) {
        this.flag = flag;
        return this;
    }

    public boolean getFlag() {
        return flag;
    }
}