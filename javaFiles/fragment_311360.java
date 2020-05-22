import org.tensorflow.*;
import java.util.Arrays;

public final class ProtoToTensor {

  public static Tensor<Float> tensorFromSerializedProto(byte[] serialized) {
    // One may way to cache the Graph and Session as member variables to avoid paying the cost of
    // graph and session construction on each call.
    try (Graph g = buildGraphToParseProto();
        Session sess = new Session(g);
        Tensor<String> input = Tensors.create(serialized)) {
      return sess.runner()
          .feed("input", input)
          .fetch("output")
          .run()
          .get(0)
          .expect(Float.class);
    }
  }

  private static Graph buildGraphToParseProto() {
    Graph g = new Graph();
    // The graph construction process in Java is currently (as of TensorFlow 1.4) very verbose.
    // Once https://github.com/tensorflow/tensorflow/issues/7149 is resolved, this should become
    // *much* more convenient and succint.
    Output<String> in =
        g.opBuilder("Placeholder", "input")
            .setAttr("dtype", DataType.STRING)
            .setAttr("shape", Shape.scalar())
            .build()
            .output(0);
    g.opBuilder("ParseTensor", "output").setAttr("out_type", DataType.FLOAT).addInput(in).build();
    return g;
  }

  public static void main(String[] args) {
    // Let's say you got a byte[] representation of the proto somehow.
    // In this case, I got it from Python from the following program
    // that serializes the 1x1 matrix:
    /*
    import tensorflow as tf
    list(bytearray(tf.make_tensor_proto([[1.]]).SerializeToString()))
    */
    byte[] bytes = {8, 1, 18, 8, 18, 2, 8, 1, 18, 2, 8, 1, 42, 4, 0, 0, (byte)128, 63};
    try (Tensor<Float> t = tensorFromSerializedProto(bytes)) {
      // You can now get an float[][] array using t.copyTo().
      // t.shape() gives shape information.
      System.out.println("Tensor: " + t);
      float[][] f = t.copyTo(new float[1][1]);
      System.out.println("float[][]: " + Arrays.deepToString(f));
    }
  }
}