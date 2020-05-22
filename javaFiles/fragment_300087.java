Map<Integer, Integer> map = new HashMap<>();
int amountOfInstances = m_instances.numInstances();
for (int i = 0; i < amountOfInstances; i++) {
  try {
    // A merge to either add a new cluster with count=1,
    // or increase the count by 1 for an already existing cluster in the map
    map.merge(clusterInstance(m_instances.instance(i)), 1, Integer::sum);
  } catch (Exception e) {
    e.printStackTrace();
  }
}

for(Map.Entry<Integer, Integer> keyValuePair : map.entrySet()){
  int cluster = keyValuePair.getKey();
  int count = keyValuePair.getValue();
  int percentage = (int)(100d / amountOfInstances * count);
  System.out.println("Cluster " + cluster + " contains " + count + " Instances (" + percentage + "%)");
}