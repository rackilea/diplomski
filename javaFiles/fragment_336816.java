// Initialize the Neural Network
algorithm.initialize(this.numberOfInputs);

int index = 0;
double errorRate = 0;

// Loop until satisfaction or after some iterations
do {
    // Train the Neural Network
    algorithm.train(this.trainingDataSets, this.numberOfInputs);

    // Validate the Neural Network and return the error rate
    errorRate = algorithm.run(this.validationDataSets, this.numberOfInputs);

    index++;
} while (errorRate > minErrorRate && index < numberOfTrainValidateIteration);