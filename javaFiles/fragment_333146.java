function pack(message) {
  var packet = new Buffer(message.length + 2);

  packet.writeIntBE(message.length, 0, 2);
  message.copy(packet, 2);

  return packet;
}