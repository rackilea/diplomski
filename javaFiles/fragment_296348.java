.on("moveAIShipForward", new Emitter.Listener() {
...
            JSONObject data = (JSONObject) args[0];
            try {
                // now here, the object looks like above (in the .js file), so `.get("i")` would return a `{ "i": 0 }` obejct, which obviously cannot be converted to int.
                int i = data.getInt("i"); // { "i": 0 } is not an integer!
....
});