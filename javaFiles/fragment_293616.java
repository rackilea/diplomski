public class BasePresenter<M extends BaseModel<M>> {

    @Nullable
    private M mModel;

    @Nullable List<M> getItems() {
        if (mModel != null) {
            return mModel.getModelList();
        }
        return null;
    }
}