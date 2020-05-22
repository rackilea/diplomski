int i = 0;
for(Map.Entry<String, Float> entry : mapData.entrySet()) {

  data[i][0] = entry.getKey();
  data[i][1] = entry.getValue().getMyFloat();
  i++;
}