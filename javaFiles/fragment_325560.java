client->waitForConencted();

// At this point the client is connected, but it is likely that no data were received yet

client->waitForReadyRead(-1); // <- Add this

// Now there should be at least 1 byte available, unless waitForConencted or waitForReadyRead failed (you should check that)

if(client->bytesAvailable() > 0) {
    // ...
}