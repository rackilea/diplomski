public class WekaJvMain {
    public static void main(String[] args) {
         try
         {  
             CSV2Arff converter =new CSV2Arff();
             converter.convert();

             DataSource source = new DataSource("data.arff");
             Instances train = source.getDataSet();

             train.setClassIndex(train.numAttributes() - 1);  // setting class attribute

             // classifier
             J48 j48 = new J48();
             j48.setUnpruned(true);        // using an unpruned J48

             //evaluate j48 with cross validation
             Evaluation eval=new Evaluation(train);

             //first supply the classifier
             //then the training data
             //number of folds
             //random seed
             eval.crossValidateModel(j48, train, 5, new Random(1));
             System.out.println("Percent correct: "+
                                Double.toString(eval.pctCorrect()));


             j48.buildClassifier(train);
             System.out.print(j48.graph());

         }
         catch(Exception e)
         {
             e.printStackTrace();
         }      
    }
}