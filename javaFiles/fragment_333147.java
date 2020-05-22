client.on('data', function (data) {
  dataBuffer = Buffer.concat([dataBuffer, data]);

  var dataLen = dataBuffer.readIntBE(0, 2);

  while(dataBuffer.length >= dataLen) {
    // Message length excluding length prefix of 2 bytes
    var msgLen = dataBuffer.readIntBE(0, 2);

    var thisMsg = new Buffer(dataBuffer.slice(2, msgLen + 2));

    //do something with the msg here

    // Remove processed message from buffer
    dataBuffer = dataBuffer.slice(msgLen + 2);
  }
});