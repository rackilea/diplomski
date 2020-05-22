Card[] sortedPacket = new Card[cards.length];

int i = 0;
for (int j = 0; j < cards.length/2 ;j++) {
    if (packetOne[j] != null) {
        sortedPacket[i++] = packetOne[j];
    }
    if (packetTwo[j] != null) {
        sortedPacket[i++] = packetTwo[j];
    }
}