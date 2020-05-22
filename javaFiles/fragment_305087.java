int batchAmount = 10;
List<List<object>> batchList = new ArrayList();
for (int i = 0; i < fullList.size(); i += batchAmount) {
    ArrayList batch = new ArrayList(fullList.subList(i, Math.min(i + batchAmount, fullList.size()));
    batchList.add(batch);
 }
 // at this point, batchList will contain a list of batches