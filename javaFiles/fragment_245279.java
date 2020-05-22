public class SentenceTrainer {
   public static void trainModel(String inputFile, String modelFile)
  throws IOException {
  Objects.nonNull(inputFile);
  Objects.nonNull(modelFile);

      MarkableFileInputStreamFactory factory = new MarkableFileInputStreamFactory(
        new File(inputFile));


    Charset charset = Charset.forName("UTF-8");
    ObjectStream<String> lineStream =
        new PlainTextByLineStream(new FileInputStream("en-chunker.train"),charset);
    ObjectStream<ChunkSample> sampleStream = new ChunkSampleStream(lineStream);

    ChunkerModel model;

    try {
      model = ChunkerME.train("en", sampleStream,
          new DefaultChunkerContextGenerator(), TrainingParameters.defaultParams());
    }
    finally {
      sampleStream.close();
    }

    OutputStream modelOut = null;
    try {
      modelOut = new BufferedOutputStream(new FileOutputStream(modelFile));
      model.serialize(modelOut);
    } finally {
      if (modelOut != null)
         modelOut.close();
      }
     }
    }