// leaves:
graph.keySet().stream()
                .filter(key -> graph.outgoingEdgesOf(key).size() == 0)
                .forEach(key -> doLeavesStuff(key));

// roots:
graph.keySet().stream()
                .filter(key -> graph.incomingEdgesOf(key).size() == 0)
                .forEach(key -> doRootsStuff(key));