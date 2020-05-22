public interface BasePage {

    BasePage basePageImpl = new BasePageImpl();

    default void basePageMethodOne() {
        basePageImpl.basePageMethodOne();
    }

    default void basePageMethodTwo() {
        basePageImpl.basePageMethodTwo();
    }
}