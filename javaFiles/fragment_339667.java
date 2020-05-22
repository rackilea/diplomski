StreamKM streamKM = new StreamKM();
streamKM.numClustersOption.setValue(5); // default setting
streamKM.widthOption.setValue(100000); // default setting
streamKM. resetLearning(); // UPDATED CODE LINE !!!
for (int i = 0; i < 150000; i++) {
    streamKM.trainOnInstanceImpl(randomInstance(2));
}
Clustering result = streamKM.getClusteringResult();
System.out.println("size = " + result.size());
System.out.println("dimension = " + result.dimension());