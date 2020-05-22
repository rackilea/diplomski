public abstract FormService<F extends Form> {
    public abstract void populate(F form);
}

public TestFormService extends FormService<TestForm> {
    @Override
    public void populate(TestForm form) {
      //populate
    }
}