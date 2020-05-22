private boolean createBlockOutputStream(DatanodeInfo[] nodes, long newGS, boolean recoveryFlag) {
    //Code..
    if (pipelineStatus != SUCCESS) {
      if (pipelineStatus == Status.ERROR_ACCESS_TOKEN) {
        throw new InvalidBlockTokenException(
            "Got access token error for connect ack with firstBadLink as "
                + firstBadLink);
      } else {
        throw new IOException("Bad connect ack with firstBadLink as "
            + firstBadLink);
      }
    }
    //Code..
}