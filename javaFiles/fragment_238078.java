// For each B
for (Agent B : populationOfB) {

  // Find all A agents that it could possibly connect with.
  // Every time we take an agent from this collection, it will shrink to ensure we don't keep trying to connect to the same A.
  List<Agent> remainingOptions = filter(

    // We start with the full population of A
    populationOfAgentA, 

    // We don't want B to connect with any A it's already connected to, so filter them out.
    A -> B.connections.isConnectedTo(A) == false

      // You might want other conditions, such as maximum distance, some specific attribute such as affordability, etc.; simply add them here with a "&&"
      /* && <Any other condition you want, if you want it.>*/
  );

  // If B ideally wants N connections total, we then try to get it N connections. We don't start i at zero because it may already have connections.
  for (int i = B.connections.getConnectionsNumber(); i < N; i += 1) {

    // Find the nearest A. (You can sort based on any property here, but you'd need to write that logic yourself.)
    Agent nearestA = B.getNearestAgent(remainingOptions);

    // Connect to the nearest A.
    B.connections.connectTo(nearestA);

    // The A we just connected to is no longer a valid option for filling the network.       
    remainingOptions.remove(nearestA);

    // If there are no other remaining viable options, we need to either quit or do something about it.
    if (remainingOptions.isEmpty()) {
      traceln("Oops! Couldn't find enough As for this B: " + B);
      break;
    }
  }
}