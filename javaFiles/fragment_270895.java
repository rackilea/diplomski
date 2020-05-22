parameters.probability = 1;
svm_model model = svm.svm_train(problem, parameters);

svm_node x[] = problem.x[0]; // let's try the first data pt in problem
double[] prob_estimates = new double[NUM_LABEL_CLASSES]; 
svm.svm_predict_probability(model, x, prob_estimates);