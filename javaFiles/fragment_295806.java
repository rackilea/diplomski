buffer.position(0);
buffer.putLong(k1Shift);
buffer.putLong(k2WithCarray);
for (byte each : buffer.array()) {
    System.out.print(Long.toHexString(each));
}

000011112222333344445555666