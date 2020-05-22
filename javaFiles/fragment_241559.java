package agent.agenttype.ijcai;
import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SparseInstance;

public class Example {

     public static enum ClassLabel {A, B};

     Instances trainingSet;
     FastVector att = new FastVector(2);
     FastVector cl = new FastVector(2);

     public Example(){
         //Add class labels
         cl.addElement(ClassLabel.values()[0].name());
         cl.addElement(ClassLabel.values()[1].name());
         //set the name of our value attribute
         Attribute Attribute1 = new Attribute("Value"); 
         //set the name of our class label atrribute
         Attribute ClassAttribute = new Attribute("Label", cl);      
         att.addElement(Attribute1);
         att.addElement(ClassAttribute);    
         //create training set that uses our attributes to interpret instances
         trainingSet = new Instances("TrainingSet", att, 2);
         trainingSet.setClassIndex(1);//tell our training set that index 2 of instances is the class label
     }

    public void addObservationToEdge(int value, ClassLabel classLabel){
            Instance instance = new SparseInstance(2);
            instance.setValue((Attribute)att.elementAt(0), value); //set value
            instance.setValue((Attribute)att.elementAt(1), classLabel.name());//set our
            trainingSet.add(instance);
    }

    public ClassLabel classifyValue( int value) throws Exception{

         Instance instanceForClassification = new SparseInstance(1);
         instanceForClassification.setValue((Attribute)att.elementAt(0), value);
         instanceForClassification.setDataset(trainingSet);//make instance inherit attribute labels from training set

         Classifier cModel = (Classifier)new NaiveBayes();//create naive bayes classifier
         cModel.buildClassifier(trainingSet);

         int labelNumber = (int) cModel.classifyInstance(instanceForClassification);
         return ClassLabel.values()[labelNumber];
    }

    public static void main(String[] args){
        Example example = new Example();
        example.addObservationToEdge(1, ClassLabel.A);
        example.addObservationToEdge(2, ClassLabel.A);
        example.addObservationToEdge(5, ClassLabel.A);
        example.addObservationToEdge(11, ClassLabel.A);
        example.addObservationToEdge(9, ClassLabel.B);
        example.addObservationToEdge(12, ClassLabel.B);
        example.addObservationToEdge(15, ClassLabel.B);
        example.addObservationToEdge(20, ClassLabel.B);

        try {
        //print classification results
        for(int i = 0; i<20; i++){
            System.out.println("Value: " + i + " Class Label:" + example.classifyValue(i));
        }
        } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }       
    }

}