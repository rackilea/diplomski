IOAcknowledge ack = new IOAcknowledge() {
@Override
public void ack(Object... args) {
    if (args.length > 0) {
        Log.d("SocketIO", "" + args[0]);
    }
}
}