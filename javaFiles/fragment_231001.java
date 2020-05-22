public void SendReply(String ipAddress) {
    final IcmpEcho icmpecho = IcmpEcho.INSTANCE;
    final InetAddr inetAddr = InetAddr.INSTANCE;
    HANDLE icmpHandle = icmpecho.IcmpCreateFile();
    byte[] message = new String("thisIsMyMessage!".toCharArray()).getBytes();
    Memory messageData = new Memory(32);                    //In C/C++ this would be: void *messageData = (void*) malloc(message.length);
    messageData.write(0, message, 0, message.length);       //but ignored the length and set it to 32 bytes instead for now
    Pointer requestData = messageData;
    Pointer replyBuffer = new Memory(256);
    replyBuffer.clear(256);

    // HERE IS THE NATIVE CALL!!
    reply = icmpecho.IcmpSendEcho(icmpHandle, 
            inetAddr.inet_addr(ipAddress), 
            requestData, 
            (short) 32, 
            null, 
            replyBuffer, 
            256, 
            timeout);
    // NATIVE CALL DONE, CHECK REPLY!!

    icmpecho.IcmpCloseHandle(icmpHandle);
}

public boolean IsReachable () {
    return (reply > 0);
}