completeDataset .addSeries("Simulated", sim); //"Simulated" will be at position 0
    completeDataset .addSeries("Experimental", exp); //"Experimental" will be at position 1

    //get series length
    int countSeries1 = completeDataset.getItemCount(0); //number of items in Simulated
    int countSeries2 = completeDataset.getItemCount(1); //number of items in Experimental

    double[][] series1 = new double[2][countSeries1];
    double[][] series2 = new double[2][countSeries2];

    //recreate Simulated series
    for(int i = 0; i < countSeries1; i++){

        series1[0][i] = completeDataset.getXValue(0, i);
        series1[1][i] = completeDataset.getYValue(0, i);

    }
    //recreate Experimental series
    for(int i = 0; i < countSeries2; i++){

        series2[0][i] = completeDataset.getXValue(1, i);
        series2[1][i] = completeDataset.getYValue(1, i);

    }