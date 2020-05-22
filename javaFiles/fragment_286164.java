import android.content.Context;
import android.content.res.AssetManager;
import org.tensorflow.contrib.android.TensorFlowInferenceInterface;


public class DigitDetector {

Context context;

public DigitDetector(Context context) {
    this.context =context;
}

static{
    System.loadLibrary("tensorflow_inference");
}

protected void onDetect(byte[] bytes){
    TensorFlowInferenceInterface inference = new TensorFlowInferenceInterface(context.getAssets(), "beginner-graph.pb");
}

}