public abstract class BaseVersionResponse<T extends BaseVO> {

    public T getVersion(BaseVO versionVO) {
        try {
            return (T) versionVO;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException();
        }
    }

    public abstract void populate(BaseVO versionVO);

}