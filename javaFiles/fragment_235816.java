import com.google.protobuf.ByteString;
import java.util.Arrays;
import org.tensorflow.*;
import org.tensorflow.example.*;

public class Main {
  // Returns a Feature containing a BytesList, where each element of the list
  // is the UTF-8 encoded bytes of the Java string.
  public static Feature feature(String... strings) {
    BytesList.Builder b = BytesList.newBuilder();
    for (String s : strings) {
      b.addValue(ByteString.copyFromUtf8(s));
    }
    return Feature.newBuilder().setBytesList(b).build();
  }

  public static Feature feature(float... values) {
    FloatList.Builder b = FloatList.newBuilder();
    for (float v : values) {
      b.addValue(v);
    }
    return Feature.newBuilder().setFloatList(b).build();
  }

  public static void main(String[] args) throws Exception {
    Features features =
        Features.newBuilder()
            .putFeature("Attribute1", feature("A12"))
            .putFeature("Attribute2", feature(12))
            .putFeature("Attribute3", feature("A32"))
            .putFeature("Attribute4", feature("A40"))
            .putFeature("Attribute5", feature(7472))
            .putFeature("Attribute6", feature("A65"))
            .putFeature("Attribute7", feature("A71"))
            .putFeature("Attribute8", feature(1))
            .putFeature("Attribute9", feature("A92"))
            .putFeature("Attribute10", feature("A101"))
            .putFeature("Attribute11", feature(2))
            .putFeature("Attribute12", feature("A121"))
            .putFeature("Attribute13", feature(24))
            .putFeature("Attribute14", feature("A143"))
            .putFeature("Attribute15", feature("A151"))
            .putFeature("Attribute16", feature(1))
            .putFeature("Attribute17", feature("A171"))
            .putFeature("Attribute18", feature(1))
            .putFeature("Attribute19", feature("A191"))
            .putFeature("Attribute20", feature("A201"))
            .build();
    Example example = Example.newBuilder().setFeatures(features).build();

    String pfad = System.getProperty("user.dir") + "\\1511523781";
    try (SavedModelBundle model = SavedModelBundle.load(pfad, "serve")) {
      Session session = model.session();
      final String xName = "input_example_tensor";
      final String scoresName = "dnn/head/predictions/probabilities:0";

      try (Tensor<String> inputBatch = Tensors.create(new byte[][] {example.toByteArray()});
          Tensor<Float> output =
              session
                  .runner()
                  .feed(xName, inputBatch)
                  .fetch(scoresName)
                  .run()
                  .get(0)
                  .expect(Float.class)) {
        System.out.println(Arrays.deepToString(output.copyTo(new float[1][2])));
      }
    }
  }
}