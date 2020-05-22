import weka.classifiers.trees.J48;
import weka.core.Instances;

public class Main {

    public static void main(String[] args) throws Exception
    {
        //load training instances
        Instances test=...

        //build a J48 decision tree
        J48 model=new J48(); 
        model.buildClassifier(test);

        //decide which instance you want to predict
        int s1=2;

        //get the predicted probabilities 
        double[] prediction=model.distributionForInstance(test.get(s1));

        //output predictions
        for(int i=0; i<prediction.length; i=i+1)
        {
            System.out.println("Probability of class "+
                                test.classAttribute().value(i)+
                               " : "+Double.toString(prediction[i]));
        }

    }

}