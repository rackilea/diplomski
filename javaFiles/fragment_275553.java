public class Updater<T extends IAppendOnlyData> {
    ...
    public abstract void processRow(Cluster cluster, T row);

}

public class UserdataUpdater extends Updater<IUserData> {
    @Override
    public void processRow(Cluster cluster, IUserData row) {
        ...
    }
}