public class CachedApiCallback<E extends RealmObject, T extends List<E>> implements Callback<T> {

    protected boolean paging;
    protected IListenable<List<E>> listener;
    protected Class<E> entityType;

    public CachedApiCallback(Class<E> entityType){
        this.entityType = entityType;
    }

    public void onSuccessfulResponse(Call<T> call, Response<T> response, int statusCode) {
        // ....
        RealmResults<E> cachedData = realm.where(entityType).findAll();
        // ....
    }
}