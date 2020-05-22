final PipedInputStream pin = getInputStream();
    final PipedOutputStream pout = getOutputStream();

    final CountDownLatch latch = new CountDownLatch(1);

    InputStream in = new InputStream() {

        @Override
        public int read() throws IOException {
            return pin.read();
        }

        @Override
        public void close() throws IOException {
            super.close();
            latch.countDown();
        }
    };


    OutputStream out = new OutputStream(){

        @Override
        public void write(int b) throws IOException {
            pout.write(b);
        }

        @Override
        public void close() throws IOException {
            while(latch.getCount()!=0) {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    //too bad
                }
            }
            super.close();
        }
    };

    //give the streams to your threads, they don't know a latch ever existed
    threadOne.feed(in);
    threadTwo.feed(out);