public void runSelector() {
    try {

        this.writebuf.clear();

        // Checking if the buffer is in write mode
        if (!(this.writebuf.limit() == this.writebuf.capacity())) {
            writebuf.flip();
        }

        this.selector = Selector.open();

        int interestSet_RW = SelectionKey.OP_READ | SelectionKey.OP_WRITE;

        int bytesRead = 0;

        byte[] bytes = null;

        SelectionKey selectionKey = this.socketChannel.register(selector, SelectionKey.OP_READ);

        while(true) {

            int readyChannels = selector.select();

            if(readyChannels == 0) continue;


            Set<SelectionKey> selectedKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while(keyIterator.hasNext()) {

                SelectionKey key = keyIterator.next();

                if (!key.isValid()) {
                    continue;
                }

                // Check if there's something to write in the queue and change interestops apropriately.
                if (monitorObject.tosendIsEmpty()) {
                    selectionKey.interestOps(SelectionKey.OP_READ);
                } else {
                    selectionKey.interestOps(interestSet_RW);
                }

                if (key.isWritable()) {
                }

                if (key.isReadable()) {

                    bytesRead = this.socketChannel.read(this.writebuf);

                    bytes = new byte[bytesRead];

                    int x = 0;

                    this.writebuf.flip();

                    while(this.writebuf.hasRemaining()) {
                        bytes[x] = this.writebuf.get();
                        x++;
                    }

                    System.out.println(new String(bytes, charset));

                    this.writebuf.flip();
                    this.writebuf.clear();
                }
                keyIterator.remove();
            }
        }




    } catch (IOException e) {
        e.printStackTrace();
    }
}