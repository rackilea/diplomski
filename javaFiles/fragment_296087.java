import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.RandomForest;  
import weka.core.Instances;
 
/**
 *
 * @author samy
 */
public class WekaTest {
 
    /**
     * @throws java.lang.Exception
     */
    public static void rfnew() throws Exception {
        BufferedReader br;
        int numFolds = 10;
        br = new BufferedReader(new FileReader("orf_arff"));
 
        Instances trainData = new Instances(br);
        trainData.setClassIndex(trainData.numAttributes() - 1);
        br.close();
        
        RandomForest rf = new RandomForest();
        rf.setNumTrees(100);         
     
        Evaluation evaluation = new Evaluation(trainData);
        evaluation.crossValidateModel(rf, trainData, numFolds, new Random(1));
        rf.buildClassifier(trainData);
        PrintWriter out = new PrintWriter("orf_out");
        out.println("No.\tTrue\tPredicted");
        for (int i = 0; i < trainData.numInstances(); i++)      
        {
            String trueClassLabel;
            trueClassLabel = trainData.instance(i).toString(trainData.classIndex());
             // Discreet prediction
            double predictionIndex = 
            rf.classifyInstance(trainData.instance(i)); 

            // Get the predicted class label from the predictionIndex.
            String predictedClassLabel;            
            predictedClassLabel = trainData.classAttribute().value((int) predictionIndex);
            out.println((i+1)+"\t"+trueClassLabel+"\t"+predictedClassLabel);
        }
        
        out.println(evaluation.toSummaryString("\nResults\n======\n", true));
        out.println(evaluation.toClassDetailsString());
        out.println("Results For Class -1- ");
        out.println("Precision=  " + evaluation.precision(0));
        out.println("Recall=  " + evaluation.recall(0));
        out.println("F-measure=  " + evaluation.fMeasure(0));
        out.println("Results For Class -2- ");
        out.println("Precision=  " + evaluation.precision(1));
        out.println("Recall=  " + evaluation.recall(1));
        out.println("F-measure=  " + evaluation.fMeasure(1)); 
        out.close();
    }
}