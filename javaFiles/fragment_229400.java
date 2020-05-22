try (DataOutputStream out = new DataOutputStream(new FileOutputStream(file))) {
    out.writeLong(uuid.getMostSignificantBits());
    out.writeLong(uuid.getLeastSignificantBits());
    out.writeLong(player.getTokens());
}

try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
    long uuidMSB = in.readLong();
    long uuidLSB = in.readLong();
    long tokens = in.readLong();
}