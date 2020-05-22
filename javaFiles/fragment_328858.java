Classifier nbTree = (Classifier)SerializationHelper.read(Model) as NBTree;
Instances testDataSet = new Instances(new BufferedReader(new FileReader(arff)));
testDataSet.setClassIndex(10);
Evaluation evaluation = new Evaluation(testDataSet);

for (int i = 0; i < testDataSet.numInstances(); i++)
{
    Instance instance = testDataSet.instance(i);
    evaluation.evaluateModelOnceAndRecordPrediction(nbTree, instance);
}

foreach (object o in evaluation.predictions().toArray())
{
    NominalPrediction prediction = o as NominalPrediction;
    if (prediction != null)
    {
        double[] distribution = prediction.distribution();
        double predicted = prediction.predicted();
    }
}