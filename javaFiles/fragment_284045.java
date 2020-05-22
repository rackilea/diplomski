public void simpleWekaTrain(String filepath)
{
try{
//Reading training arff or csv file
FileReader trainreader = new FileReader(filepath);
Instances train = new Instances(trainreader);
train.setClassIndex(train.numAttributes() – 1);
//Instance of NN
MultilayerPerceptron mlp = new MultilayerPerceptron();
//Setting Parameters
mlp.setLearningRate(0.1);
mlp.setMomentum(0.2);
mlp.setTrainingTime(2000);
mlp.setHiddenLayers(“3?);
mlp.buildClassifier(train);
}
catch(Exception ex){
ex.printStackTrace();
}
}