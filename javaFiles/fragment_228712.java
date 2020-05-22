/**
 * Send one byte of urgent data on the socket.
 * @see java.net.Socket#sendUrgentData
 * At this point, there seems to be no specific requirement to support
 * this for an SSLSocket. An implementation can be provided if a need
 * arises in future.
 */
@Override
public final void sendUrgentData(int data) throws SocketException {
    throw new SocketException("This method is not supported "
                    + "by SSLSockets");
}