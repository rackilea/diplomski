public void train() {

for (int i = 0; i < happyRating.size()-1; i++) {

    if (happyRating.get(i) < happyRating.size()){

        int x, x1, x2, y, y1, y2;
        double learningRate = -0.00002;

        x1 = happyRating.get(i+1);
        x2 = happyRating.get(i);
        y1 = iteration[i+1];
        y2 = iteration[i];

        x = x2 - x1;
        y = y2 - y1;

        if (x == 0) {
            slope = 0;
        } else {
            slope = (y2 - y1) / (x2 - x1);
        }
        j++;

        Log.d("J: ", Integer.toString(j));

        double weightAdj = happyRating.get(j) * slope * learningRate;

        weighting = (weighting + weightAdj);

        Log.d("WEIGHTING: ", Double.toString(weighting));// break;

    }
    else
    {
        break;
    }

}