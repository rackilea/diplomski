public interface IPage {
    default <T extends IPage> T getProxyInstance() {
        try {
            return (T) IPageProxy.getInstance(this.getClass());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}