/**
* This method performs classification of unseen instance. 
* It starts by training a model using a selection of classifiers then classifiy new unlabled instances.
*/

    public static void predict() throws Exception {
        //start by providing the paths for your training and testing ARFF files make sure both files have the same structure and the exact classes in the header

        //initialise classifier
        Classifier classifier = null;

        System.out.println("read training arff");

        Instances train = new Instances(new BufferedReader(new FileReader("Train.arff")));
        train.setClassIndex(0);//in my case the class was the first attribute thus zero otherwise it's the number of attributes -1

        System.out.println("read testing arff");
        Instances unlabeled = new Instances(new BufferedReader(new FileReader("Test.arff")));
        unlabeled.setClassIndex(0);

        // training using a collection of classifiers (NaiveBayes, SMO (AKA SVM), KNN and Decision trees.)
        String[] algorithms = {"nb","smo","knn","j48"};
        for(int w=0; w<algorithms.length;w++){
            if(algorithms[w].equals("nb"))
            classifier = new NaiveBayes();
            if(algorithms[w].equals("smo"))
            classifier = new SMO();
            if(algorithms[w].equals("knn"))
            classifier = new IBk();
            if(algorithms[w].equals("j48"))
            classifier = new J48();

        System.out.println("==========================================================================");
        System.out.println("training using " + algorithms[w] + " classifier");

        Evaluation eval = new Evaluation(train);
        //perform 10 fold cross validation
        eval.crossValidateModel(classifier, train, 10, new Random(1));
        String output = eval.toSummaryString();
        System.out.println(output);

        String classDetails = eval.toClassDetailsString();
        System.out.println(classDetails);

        classifier.buildClassifier(train);
        }

        Instances labeled = new Instances(unlabeled);

        // label instances (use the trained classifier to classify new unseen instances)
        for (int i = 0; i < unlabeled.numInstances(); i++) {
            double clsLabel = classifier.classifyInstance(unlabeled.instance(i));
            labeled.instance(i).setClassValue(clsLabel);
            System.out.println(clsLabel + " -> " + unlabeled.classAttribute().value((int) clsLabel));
        }

            //save the model for future use
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("myModel.dat"));
            out.writeObject(classifier);
            out.close();
            System.out.println("===== Saved model =====");

        }