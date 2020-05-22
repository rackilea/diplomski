public class TestFactoryBean implements FactoryBean<TestBean> {

  // the rest of the required methods are removed for simplicity reasons..

  public boolean isSingleton() {
        return false;
    }
}