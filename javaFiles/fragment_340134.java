public void exitNodeB(NodeBContext ctx) {
    super.exitNodeB(ctx);
    NodeBDescriptor descriptor = (NodeBDescriptor) getDescriptor(ctx);
    if (analysisPhase) {
        descriptor.process(); // node-type specific analysis
    } else {
        descriptor.output();  // node-type specific output generation
    }
}