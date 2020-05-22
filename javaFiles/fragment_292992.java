import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;

import javax.inject.Inject;
import javax.inject.Provider;

import com.sampleapp.model.Model;

public class SimpleWorker extends androidx.work.Worker {

//dagger (what we want to Inject into worker) U CAN ADD WHATEVER NEEDED
private Model model;

//not dagger (just some fields)
private String someField;
private final String TAG = getClass().getSimpleName();

private SimpleWorker(@NonNull Context context,
                     @NonNull WorkerParameters workerParams,
                     Model model) {
    super(context, workerParams);
    this.model = model;

    someField = "just some work";
}

@NonNull
@Override
public ListenableWorker.Result doWork() {
    Log.d(TAG, "Worker starts");
    Log.d(TAG, model.getClass().getSimpleName() + " doing some work");
    Log.d(TAG, "Job done!");
    return ListenableWorker.Result.success();
}

public static class Factory implements ChildWorkerFactory {

    private final Provider<Model> modelProvider;

    @Inject
    public Factory(Provider<Model> modelProvider) {
        this.modelProvider = modelProvider;
    }

    @Override
    public ListenableWorker create(Context context, WorkerParameters workerParameters) {
        return new SimpleWorker(context,
                workerParameters,
                modelProvider.get());
    }
}
}