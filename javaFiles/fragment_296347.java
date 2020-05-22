// here, the `i` is what you have sent earlier: `{ "i": 0 }`
socket.on("moveAIShipForward", function(i) {
    // here, you are passing the `{ "i": 0 }` object to the new object, under `i` key, the resulting object looks like this:
    // `{ id: 0, i: { i: 0 } }`
    // and it's emitted
    socket.broadcast.emit("moveAIShipForward", {id: socket.id, i: i})
});