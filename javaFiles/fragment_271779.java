@Override
protected Void doInBackground() {
    this.treeModelUpdater.execute();
    // Omitted; performs variable processing to build a tree of address nodes.
}

@Override
protected void process(List<NodePair> chunks) {
    this.queue.addAll( chunks ); // a blocking queue
}

@Override
protected void done() {
    // Null Object as sentinel value to unblock TreeModelUpdater
    // and signal it to end doInBackground.
    this.queue.put( new NullNodePair() );
}