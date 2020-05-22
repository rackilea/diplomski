let packets = [
  { id: 1001, weight: 8.37 },
  { id: 1002, weight: 2.17 },
  { id: 1003, weight: 11.35 }
];

console.log(heavyestPacketFrom(packets));

function heavyestPacketFrom(packets, index, heavyestPacket) {
    
    index = index || 0;
    heavyestPacket = heavyestPacket || packets[index] || null;

    if (index >= packets.length) return heavyestPacket;

    let packet = packets[index];

    if (packet.weight > heavyestPacket.weight) {
        heavyestPacket = packet;
    }

    return heavyestPacketFrom(packets, index + 1, heavyestPacket);
}