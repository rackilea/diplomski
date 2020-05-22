// rootPath should be where the .arff file is held
// filename should hold the complete name of the .arff file
public static Instances instanceData(String rootPath, String filename) throws Exception
{ 
  // initialize source 
  DataSource source = null;
  Instances data = null;
  source = new DataSource(rootPath + filename);
  data = source.getDataSet(); 
  // set the class to the last attribute of the data (may need to tweak) 
  if (data.classIndex() == -1)
   data.setClassIndex(data.numAttributes() -1 );
  return data;
}