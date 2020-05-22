class NeuralNetwork {
    int netSize;
    float learningRate;
    Matrix[] weights;
    Matrix[] biases;
    Matrix[] activations;
    Matrix[] sums;
    Matrix[] errors;

    NeuralNetwork(int inNum, int hiddenNum, int[] hiddenLayerSize, int outNum, float learningRate) {
        netSize = hiddenNum + 1;
        this.learningRate = learningRate;

        weights = new Matrix[netSize];
        biases = new Matrix[netSize - 1];
        activations = new Matrix[netSize];
        sums = new Matrix[netSize];
        errors = new Matrix[netSize];

        initializeMatrices(inNum, hiddenNum, hiddenLayerSize, outNum);
    }

    //INITIALIZING MATRICES
    void initializeMatrices(int inNum, int hiddenNum, int[] layerSize, int outNum) {

        for (int i = 0; i < hiddenNum; i++) {
            if (i == 0)
                weights[i] = new Matrix(layerSize[0], inNum);
            else
                weights[i] = new Matrix(layerSize[i], layerSize[i - 1]);

            biases[i] = new Matrix(layerSize[i], 1);
            activations[i] = new Matrix(layerSize[i], 1);
            errors[i] = new Matrix(layerSize[i], 1);
            sums[i] = new Matrix(layerSize[i], 1);

            weights[i].randomize(-1, 1);
            biases[i].randomize(-1, 1);
            activations[i].randomize(-1, 1);
        }

        weights[netSize - 1] = new Matrix(outNum, layerSize[layerSize.length - 1]);
        activations[netSize - 1] = new Matrix(outNum, 1);
        errors[netSize - 1] = new Matrix(outNum, 1);
        sums[netSize - 1] = new Matrix(outNum, 1);

        weights[netSize - 1].randomize(-1, 1);
        activations[netSize - 1].randomize(-1, 1);
    }

    //---------------------------------------------------------------------------------------------------------------

    void forwardPropag(float[] ins) {
        Matrix inputs = new Matrix(0, 0);
        inputs = inputs.arrayToCollumn(ins);

        sums[0] = (weights[0].matrixMult(inputs)).sum(biases[0]);
        activations[0] = sigM(sums[0]);

        for (int i = 1; i < netSize - 1; i++) {
            sums[i] = (weights[i].matrixMult(activations[i - 1])).sum(biases[i]);
            activations[i] = sigM(sums[i]);
        }

        //output layer does not have biases
        sums[netSize - 1] = weights[netSize - 1].matrixMult(activations[netSize - 2]);
        activations[netSize - 1] = sigM(sums[netSize - 1]);
    }

    Matrix predict(float[] inputs) {
        forwardPropag(inputs);
        return activations[netSize - 1].copyM();
    }

    //SUPERVISED LEARNING - BACKPROPAGATION
    void train(float[] inps, float[] expec) {
        Matrix expected = new Matrix(0, 0);
        expected = expected.arrayToCollumn(expec);

        errors[netSize - 1] = predict(inps).diff(expected);

        calcErorrPrevLayers();

        adjustWeights(inps);
        adjustBiases();

        for (Matrix m : errors){
            m.reset();
        }
    }

    void calcErorrPrevLayers() {
        for (int l = netSize - 2; l >= 0; l--) {
            for (int i = 0; i < activations[l].i; i++) {
                for (int j = 0; j < activations[l + 1].i; j++) {
                    errors[l].values[i][0] += weights[l + 1].values[j][i] * dSig(sums[l + 1].values[j][0]) * errors[l + 1].values[j][0];
                }
            }
        }
    }

    void adjustWeights(float[] inputs) {
        for (int l = 0; l < netSize; l++) {
            if (l == 0) {
                //for ervery neuron n in the first layer
                for (int n = 0; n < activations[l].i; n++) {
                    //for every weight w of the first layer
                    for (int w = 0; w < inputs.length; w++) {
                        float weightChange = inputs[w] * dSig(sums[l].values[n][0]) * errors[l].values[n][0];
                        weights[l].values[n][w] += -learningRate * weightChange;
                    }
                }
            } else {
                //for ervery neuron n in the first layer
                for (int n = 0; n < activations[l].i; n++) {
                    //for every weight w of the first layer
                    for (int w = 0; w < activations[l - 1].i; w++) {
                        float weightChange = activations[l - 1].values[w][0] * dSig(sums[l].values[n][0]) * errors[l].values[n][0];
                        weights[l].values[n][w] += -learningRate * weightChange;
                    }
                }
            }
        }
    }

    void adjustBiases() {
        for (int l = 0; l < netSize - 1; l++) {
            //for ervery neuron n in the first layer
            for (int n = 0; n < activations[l].i; n++) {
                float biasChange = dSig(sums[l].values[n][0]) * errors[l].values[n][0];
                biases[l].values[n][0] += -learningRate * biasChange;
            }
        }
    }

    //ACTIVATION FUNCTION
    float sig(float x) {
        return 1 / (1 + exp(-x));
    }

    float dSig(float x) {
        return sig(x) * (1 - sig(x));
    }

    Matrix sigM(Matrix m) {
        Matrix temp = m.copyM();
        for (int i = 0; i < m.i; i++) {
            for (int j = 0; j < m.j; j++) {
                temp.values[i][j] = sig(m.values[i][j]);
            }
        }

        return temp;
    }
}