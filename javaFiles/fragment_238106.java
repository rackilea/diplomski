public int readInt(int min, int max) throws QuantisException, InterruptedException {
    ticket.acquire();
    try {
        return quantisReadScaledInt(deviceType.getType(), deviceNumber, min, max);
    }
    finally {
        ticket.release();
    }
}