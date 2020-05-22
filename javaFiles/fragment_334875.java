/**
 * Open a DataOutputStream to a DataNode pipeline so that 
 * it can be written to.
 * This happens when a file is appended or data streaming fails
 * It keeps on trying until a pipeline is setup
 */
private boolean setupPipelineForAppendOrRecovery() throws IOException {
    //Code..
    while (!success && !streamerClosed && dfsClient.clientRunning) {
        //Code..
        success = createBlockOutputStream(nodes, newGS, isRecovery);
    }
    //Code..
}