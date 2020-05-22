rv = connect(fd, (struct sockaddr *)&sa, sa_len);
if (rv == SOCKET_ERROR) {
    int err = WSAGetLastError();
    if (err == WSAEWOULDBLOCK) {
        return java_net_DualStackPlainSocketImpl_WOULDBLOCK;
    } else if (err == WSAEADDRNOTAVAIL) {
        JNU_ThrowByName(env, JNU_JAVANETPKG "ConnectException",
            "connect: Address is invalid on local machine, or port is not valid on remote machine");
    } else {
        NET_ThrowNew(env, err, "connect");
    }
    return -1;  // return value not important.
}