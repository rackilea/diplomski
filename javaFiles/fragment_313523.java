// Initialize.
for (int j = 0; j < numOfConnections; j++) {
//                  ^ I assume this means 'count' here.
    map[j] = new LinkedList<Connection>();
}

// Fill
for (int j = 0; j < numOfConnections; j++) {
    map[j].add(new Connection(find(s.next()), s.nextDouble(), s.next()));
//      ^ BTW I think you mean `j` here.
}