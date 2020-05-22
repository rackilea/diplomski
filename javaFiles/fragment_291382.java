PreparedStatement prep = conn.prepareStatement(INSERT_CPU_USAGE);
for (CpuData o : mData.getCpu()) {
    prep.setObject(1, this.nodeID);
    prep.setObject(2, timeID);
    prep.setObject(3, o);
    prep.addBatch();
}
prep.executeBatch();