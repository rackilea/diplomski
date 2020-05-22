Instances datapredict = new Instances(
new BufferedReader(
new FileReader(<Predictdatapath>)));
datapredict.setClassIndex(datapredict.numAttributes() – 1);
Instances predicteddata = new Instances(datapredict);
//Predict Part
for (int i = 0; i < datapredict.numInstances(); i++) {
double clsLabel = mlp.classifyInstance(datapredict.instance(i));
predicteddata.instance(i).setClassValue(clsLabel);
}
//Storing again in arff
BufferedWriter writer = new BufferedWriter(
new FileWriter(<Output File Path>));
writer.write(predicteddata.toString());
writer.newLine();
writer.flush();
writer.close();