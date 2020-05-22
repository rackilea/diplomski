public class UIUpdaterWorker extends Worker {
    private String TAG = getClass().getSimpleName();

    public UIUpdaterWorker(
            @NonNull Context context,
            @NonNull WorkerParameters workerParams,
            @NonNull DBModel dbModel
    ) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d(TAG, dbModel.toString());
        return Result.success();
    }
}