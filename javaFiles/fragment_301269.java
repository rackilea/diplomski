void NeuralNet::updateWeights() {
    // the operator () (int l, int w) returns a double reference at that position in the matrix
    // thet operator [] (int n) returns the nth double (reference) in the matrix (useful for vectors) 
    for (int l = 0; l < layers - 1; ++l) {
        for (int i = 1; i < d(l + 1).length(); ++i) {
            for (int j = 0; j < a(l).length(); ++j) {
                w(l)(i - 1, j) -= (d(l + 1)[i] * a(l)[j]) * learningRate + m(l)(i - 1, j);
                m(l)(i - 1, j) = (d(l + 1)[i] * a(l)[j]) * learningRate * momentumRate;
            }
        }
    }
}