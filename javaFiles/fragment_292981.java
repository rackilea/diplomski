class ParallelDataObject {

    @Test
    public void passM1() {
        final HelperClass helperClass = new HelperClass(new Data());

        helperClass.verifyFlag();
    }

    @Test
    public void failM2() {
        final Data data = new Data();
        data.setFlag(false);

        final HelperClass helperClass = new HelperClass(data);

        helperClass.verifyFlag();
    }

}