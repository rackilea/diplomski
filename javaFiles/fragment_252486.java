Collection<XYChar.Data<Integer,Double>> samples = new ArrayList<>(numsamples);

for (int i = 0; i < numsamples; i++) {
     XYChart.Data sample = new XYChart.Data<Integer,Double>( i, samples[i]);
     samples.getData().add(sample);
}   

dataSeries1.getData().addAll(samples);