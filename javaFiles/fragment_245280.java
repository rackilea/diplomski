public class Main {

public static void main(String args[]) throws IOException {
  String inputFile = "//path//to//data.train";
  String modelFile = "//path//to//.bin";

  SentenceTrainer.trainModel(inputFile, modelFile);
 }
}