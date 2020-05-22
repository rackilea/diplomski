@Override
public EventExecutor executor() {
    if (executor == null) {
        return channel().eventLoop();
    } else {
        return executor;
    }
}