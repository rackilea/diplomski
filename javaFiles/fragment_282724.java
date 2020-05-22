import weka.classifiers.functions.LibSVM; // contained in LibSVM.jar

String path = "file/train.arff";
Instances train = DataSource.read(path); // load the dataset
train.setClassIndex(train.numAttribute()-1); // set class index

LibSVM svm = new LibSVM(); // load the svm classifier
svm.buildClassifier(train);

Evaluation eval = new Evaluation(train);
eval.crossValidateModel(svm, train, 10, new Random(1)); // 10-fold cross-validation