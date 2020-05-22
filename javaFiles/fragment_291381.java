for (CpuData o : mData.getCpu()) {
    // this is wrong, you can not prepare a new query each time
    prep = this.conn.prepareStatement(INSERT_CPU_USAGE);
    prep.setObject(1, this.nodeID);
    prep.addBatch();
}