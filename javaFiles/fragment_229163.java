try (SavedModelBundle model = SavedModelBundle.load("./saved_model/1518198088", "serve")) {
  // A batch of inputs. In real life of course you'd set each row to the actual input you're
  // interested in.
  final int BATCH_SIZE = 1;
  float[][] in = new float[BATCH_SIZE][32];
  try (Tensor<Float> tInput = Tensors.create(in);
      Tensor<Float> tProbs =
          model.session().runner()
              .feed("Placeholder", tInput)
              .fetch("dnn/head/predictions/probabilities")
              .run().get(0).expect(Float.class)) {
    float[][] probabilities = tProbs.copyTo(new float[BATCH_SIZE][4]);
    System.out.print("Predicted class probabilities: ");
    for (int i = 0; i < probabilities.length; ++i) {
      System.out.println(String.format("-- Input #%d", i));
      for (int j = 0; j < probabilities[i].length; ++j) {
        System.out.println(String.format("Class %d - %f", i, probabilities[i][j]));
      }
    }
  }
}