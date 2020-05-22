// Sends a request to the nodes
// The Controller is blocked here until all answers have been received
fetchNodes(requestedNodes, DevicePing[0], null);

// Clears the cache to avoid inconsistency
entityManager.clear();

// Retrieves the list of nodes again
nodes = nodeRepository.findAll();