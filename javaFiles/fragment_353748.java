public class Abc {

    private class ExpectedErrorsTable extends ErrorsTable {
        public ErrorsTable addError(String error) {
            this.add(error);
            return this;
        }
    }

    private ExpectedErrorsTable expectedErrorsTable = new ExpectedErrorsTable();

    public void someMethod() {
        expectedErrorsTable.addError("abc");
    }

}