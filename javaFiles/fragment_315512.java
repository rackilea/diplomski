BufferStrategy bs = this.getBufferStrategy();
if(bs == null){
    createBufferStrategy(3);
    bs = this.getBufferStrategy();
}

if (bs == null) {
    // It might not be possible to create a buffer strategy for your hardware,
    // or the component is not attached to a native peer
} else {
    // Start painting :D
}