int batchSize = 10;
ArrayList<Integer> batch = new ArrayList<Integer>();
for (int i = 0; i < fullList.size();i++) {
    batch.add(fullList.get(i));
    if (batch.size() % batchSize == 0 || i == (fullList.size()-1)) {
        //ToDo Process the batch;
        batch = new ArrayList<Integer>();
    }
}