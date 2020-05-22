//////This is where I want the 2 thread to wait for me to do this so that the zoom class finishes doing its things that I have previously sent
            mouseClickedLock.writeLock().lock();
            try {
                zoom1.activarBoolTrue();
                zoom.activarBoolTrue();
            } finally {
                mouseClickedLock.writeLock().unlock();
            }