public static void sendAsBatch(int batchSize, byte[] payload, UsbPipe pipe) throws UsbException {

   int offset = 0;
   for (int multiplier = 1; offset < payload.length; multiplier++) {

      byte[] batch = offset + batchSize < payload.length ?
            Arrays.copyOfRange(payload, offset, offset + batchSize) :
            Arrays.copyOfRange(payload, offset, payload.length);

      pipe.syncSubmit(batch);
      offset = multiplier * batchSize;
   }
}