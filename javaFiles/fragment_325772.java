public String sendCommand(@RequestParam String command, @RequestParam String args) {

    String cmd = StringUtils.upperCase(command);
    String[] argsArray = args.split(" ");
    Object result;

    if (argsArray.length > 0) {
        byte[][] byteArray = new byte[argsArray.length][];
        for (int i = 0; i < argsArray.length; i++) {
            byte[] element = SerializationUtils.serialize(argsArray[i]);
            byteArray[i] = element;
        }

        result = ohcCacheStrategy.sendCommand(OffheapCacheCommand.valueOf(cmd), byteArray);
    } else {
        result = ohcCacheStrategy.sendCommand(OffheapCacheCommand.valueOf(cmd));
    }
    return JSON.toJSONString(result);
}