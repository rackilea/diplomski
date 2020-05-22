private static final class ArrayByteBufferTest extends IterationTest {
    private final FloatBuffer floatBuffer;
    private final int vectorSize;
    private final int nVectors;

    ArrayByteBufferTest(float[] data, int vectorSize, int nVectors) {
      ByteBuffer bb = ByteBuffer.wrap(new byte[data.length * 4]);
      for (int i = 0; i < data.length; i++) {
        bb.putFloat(data[i]);
      }
      bb.rewind();
      this.floatBuffer = bb.asFloatBuffer();
      this.vectorSize = vectorSize;
      this.nVectors = nVectors;
    }

    float iterate() {
      float sum = 0;
      floatBuffer.rewind();
      float[] vector = new float[vectorSize];
      for (int i = 0; i < nVectors; i++) {
        floatBuffer.get(vector);
        sum += calc(vector, 0, vector.length);
      }
      return sum;
    }
  }