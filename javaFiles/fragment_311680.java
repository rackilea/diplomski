// sending received data to other clients except the one from which data has been received
// (so that all clients can receive other clients' data indirectly via this server)
for (int j = 0; j < i; j++) {
    sendThreads[j].send(receivedChar);  // instead of sendThreads[i]
    //Common.send(sendStreams[j], receivedChar);
}
for (int j = i + 1; j < Common.totalClients; j++) {
    sendThreads[j].send(receivedChar);  // instead of sendThreads[i]
    //Common.send(sendStreams[j], receivedChar);
}