} catch (java.net.SocketException e) {
    // SocketExceptions are normal
    Http11NioProtocol.log.debug
        (sm.getString
         ("http11protocol.proto.socketexception.debug"), e);

} catch (java.io.IOException e) {
    // IOExceptions are normal
    Http11NioProtocol.log.debug

        (sm.getString
         ("http11protocol.proto.ioexception.debug"), e);

}