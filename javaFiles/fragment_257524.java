// Should be outside of your serialEvent method
StringBuilder buffer = new StringBuilder();

public synchronized void serialEvent(SerialPortEvent oEvent) {
    if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
        try {
            int available = input.available();
            byte chunk[] = new byte[available];
            input.read(chunk, 0, available);

            // We store data in a buffer
            buffer.append(new String(chunk));
            // We check if we received the characters indicating
            // the end of your data
            int endOfLineIndex = buffer.indexOf("\r\n");
            // We don't, so we leave and wait for more data
            if (endOfLineIndex == -1) { 
                return;
            }

            // The "+2" is to keep the "\r\n"
            String print = buffer.substring(0, endOfLineIndex+2);
            // Do not forget to remove what was used in the buffer
            buffer.delete(0, endOfLineIndex+2);

            test.write(print);
            System.out.print(print);

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    // Ignore all the other eventTypes, but you should consider the other ones.
}