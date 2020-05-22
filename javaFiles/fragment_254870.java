public static double calcLoss() {
    if (null != y_true && null != y_pred && y_pred.length == y_true.length) {
        for (int i = 0; i < y_true.length; i++) {
            double a = (1d / y_true.length) * Math.pow(y_true[i] - y_pred[i], 2);
            // This is just re-assigning loss. Are you sure this is what you intended here?
            loss = a;
        }       
        return loss;
    }
    // y_true is NULL.
    return -1;
}