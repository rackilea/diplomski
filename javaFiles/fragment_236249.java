private static final String INPUT_NODE = "input:0"; // input tensor name
    private static final String OUTPUT_NODE = "output:0"; // output tensor name
    private static final String[] OUTPUT_NODES = {"output:0"}; 
    private static final int OUTPUT_SIZE = 10; // number of classes
    private static final int INPUT_SIZE = 784; // size of the input
    INPUT_IMAGE //MNIST Image
    float[] result = new float[OUTPUT_SIZE]; // get the output probabilities for each class

    inferenceInterface.feed(INPUT_NODE, INPUT_IMAGE, 1, INPUT_SIZE); //1-D input (1,INPUT_SIZE)
    inferenceInterface.run(OUTPUT_NODES);
    inferenceInterface.fetch(OUTPUT_NODE, result);