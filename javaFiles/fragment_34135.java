public interface BasePortalPage {

    BasePortalPage basePageImpl = new BasePortalPageImpl();

    default void basePortalPageMethodOne(){
        basePageImpl.basePortalPageMethodOne();
    }

    default void basePortalPageMethodTwo(){
        basePageImpl.basePortalPageMethodTwo();
    }
}