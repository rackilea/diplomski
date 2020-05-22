JSONObject data = new JSONObject();
...
    data.put("i", identifier);

    // here the `data` is like `{ "i": 0 }` and it's emmited
    gameScreen.spaceSoccer.socket.emit("moveAIShipForward", data);
...